package ar.com.alk.disney.service;

import ar.com.alk.disney.component.BusinessLogicExceptionComponent;
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
        return null;
    }


    //En el detalle deberán listarse todos los atributos del personaje, como así también sus películas o
    //series relacionadas

    public PersonajeDTO createNew(PersonajeDTO dto, Long id) {

        PeliculaoSerie peliculaoSerie = peliculaoSerieRepository

                .findById(id)
                .orElseThrow(()->logicExceptionComponent.getExceptionEntityNotFound("PeliculaoSerie", id));
        Personaje personajeToSave=personajeMapper.toEntity(dto,context);
        personajeToSave.setPeliculaoSerie(peliculaoSerie);
        personajeRepository.save(personajeToSave);
        PersonajeDTO personajeSaved= personajeMapper.toDTO(personajeToSave,context);
        return personajeSaved;


}
    public List<PersonajeDTO> getAll() {
        List<Personaje> personajeList = personajeRepository.findAll();
        //Basicamente el metodo .findAll() hace la query select * from
        List<PersonajeDTO> personajes = personajeMapper.toDTO(personajeList, context);

        return personajes;
    }

    @Override
    public PersonajeDTO getById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void mergeData(Personaje entity, PersonajeDTO dto) {

    }



    @Override
    public PersonajeDTO update(PersonajeDTO dto, Long id) {
        return null;
    }

}
