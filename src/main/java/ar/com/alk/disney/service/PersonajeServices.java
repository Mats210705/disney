package ar.com.alk.disney.service;

import ar.com.alk.disney.component.BusinessLogicExceptionComponent;
import ar.com.alk.disney.model.dto.PeliculaoSerieDTO;
import ar.com.alk.disney.model.dto.PersonajeDTO;

import ar.com.alk.disney.model.entity.PeliculaoSerie;
import ar.com.alk.disney.model.entity.Personaje;
import ar.com.alk.disney.model.mapper.AvoidingMappingContext;
import ar.com.alk.disney.model.mapper.PersonajeMapper;
import ar.com.alk.disney.model.repository.PeliculaoSerieRepository;
import ar.com.alk.disney.model.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServices implements Services<PersonajeDTO, Personaje> {
    //en este servicio implemento la interfaz con la entidad correspondiete
    // siempre es con referencia a los DTO, que es lo que defini como tipo en service=(T dto)

    private PersonajeMapper personajeMapper = PersonajeMapper.MAPPER;
    @Autowired
    private AvoidingMappingContext context;

    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PeliculaoSerieRepository peliculaoSerieRepository;

    //carga nuevo personaje
    @Override
    public PersonajeDTO createNew(PersonajeDTO dto) {

        Personaje personaje = personajeMapper.toEntity(dto, context);
        //se le pide al repository que cuarde la entidad
        personajeRepository.save(personaje);
        PersonajeDTO personajeSaved = personajeMapper.toDTO(personaje, context);
        return personajeSaved;
    }



    public List<PersonajeDTO> getAll() {
        List<Personaje> personajeList = personajeRepository.findAll();
        //Basicamente el metodo .findAll() hace la query select * from
        List<PersonajeDTO> personajeDTOS = personajeMapper.toDTO(personajeList, context);

        return personajeDTOS;
    }

    @Override
    public PersonajeDTO getById(Long id) {
        Optional<Personaje> personajeOptional = personajeRepository.findById(id);

        Personaje personaje = personajeOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Personaje", id));

        PersonajeDTO personajeDTO = personajeMapper.toDTO(personaje, context);

        return personajeDTO;
    }


    public PersonajeDTO getByImage(String imagen) {
        Optional<Personaje> personajeOptional = personajeRepository.findByImage (imagen);

        Personaje personaje = personajeOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityEmptyValues("Personaje"));

        PersonajeDTO personajeDTO = personajeMapper.toDTO(personaje, context);

        return personajeDTO;
    }

    public PersonajeDTO getByName(String nombre) {
        Optional<Personaje> personajeOptional= personajeRepository.findByName(nombre);

        Personaje personaje = personajeOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityEmptyValues("Personaje"));

        PersonajeDTO personajeDTO = personajeMapper.toDTO(personaje, context);

        return personajeDTO;
    }

    @Override
    public void remove(Long id) {
        Optional<Personaje>personajeByIdToDelete= personajeRepository.findById(id);
        Personaje personaje=personajeByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Personaje",id));
        personajeRepository.deleteById(id);

    }

    @Override
    public void mergeData(Personaje entity, PersonajeDTO dto) {
        if (dto.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("PeliculaoSerie");

        if (!entity.getImagen().equals(dto.getImagen()))
            entity.setImagen(dto.getImagen());
        if (!entity.getTitulo().equals(dto.getTituto()))
            entity.setTitulo(dto.getTituto());
        if (!entity.getFechaDeCreacion().equals(dto.getFechaDeCreacion()))
            entity.setFechaDeCreacion(dto.getFechaDeCreacion());
        if (!entity.getCalificacion().equals(dto.getCalificacion()))
            entity.setCalificacion(dto.getCalificacion());


    }


    @Override
    public PersonajeDTO update(PersonajeDTO dto, Long id) {
        Optional<Personaje> personajeOptional = personajeRepository.findById(id);

        Personaje personajeById = personajeOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Personaje", id));

        mergeData(personajeById, dto);

        personajeRepository.save(personajeById);

        PersonajeDTO personajeUpdated =  personajeMapper.toDTO(personajeById, context);

        return personajeUpdated;
    }

}
