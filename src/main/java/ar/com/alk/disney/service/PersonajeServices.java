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


    //MOSTRAR
    public List<PersonajeDTO> getAll() {
        List<Personaje> personajeList = personajeRepository.findAll();
        //Basicamente el metodo .findAll() hace la query select * from
        List<PersonajeDTO> personajeDTOS = personajeMapper.toDTO(personajeList, context);

        return personajeDTOS;
    }
    //MOSTRAR POR ID
    @Override
    public PersonajeDTO getById(Long id) {
        Optional<Personaje> personajeOptional = personajeRepository.findById(id);

        Personaje personaje = personajeOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Personaje", id));

        PersonajeDTO personajeDTO = personajeMapper.toDTO(personaje, context);

        return personajeDTO;
    }

    //MOSTRAR POR IMAGEN
    public PersonajeDTO getByImage(String imagen) {
        Optional<Personaje> personajeOptional = personajeRepository.findByImage (imagen);

        Personaje personaje = personajeOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityEmptyValues("Personaje"));

        PersonajeDTO personajeDTO = personajeMapper.toDTO(personaje, context);

        return personajeDTO;
    }
   //MOSTRAR POR NOMBRE
    public PersonajeDTO getByName(String nombre) {
        Optional<Personaje> personajeOptional= personajeRepository.findByName(nombre);

        Personaje personaje = personajeOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityEmptyValues("Personaje"));

        PersonajeDTO personajeDTO = personajeMapper.toDTO(personaje, context);

        return personajeDTO;
    }
   //ELIMINAR
    @Override
    public void remove(Long id) {
        Optional<Personaje>personajeByIdToDelete= personajeRepository.findById(id);
        Personaje personaje=personajeByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Personaje",id));
        personajeRepository.deleteById(id);

    }
   //MERGE
    @Override
    public void mergeData(Personaje entity, PersonajeDTO dto) {
        if (dto.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("Personaje");

        if (!entity.getNombre().equals(dto.getNombre()))
            entity.setNombre(dto.getNombre());
        if (!entity.getEdad().equals(dto.getEdad()))
            entity.setEdad(dto.getEdad());
        if (!entity.getImagen().equals(dto.getImagen()))
            entity.setImagen(dto.getImagen());
        if (!entity.getHistoria().equals(dto.getHistoria()))
            entity.setHistoria(dto.getHistoria());


    }

   // ACTUALIZAR
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
