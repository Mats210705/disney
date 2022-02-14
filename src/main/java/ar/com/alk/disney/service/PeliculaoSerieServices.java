package ar.com.alk.disney.service;

import ar.com.alk.disney.component.BusinessLogicExceptionComponent;
import ar.com.alk.disney.model.dto.PeliculaoSerieDTO;
import ar.com.alk.disney.model.entity.PeliculaoSerie;
import ar.com.alk.disney.model.entity.Personaje;
import ar.com.alk.disney.model.mapper.AvoidingMappingContext;
import ar.com.alk.disney.model.mapper.PeliculaoSerieMapper;
import ar.com.alk.disney.model.repository.PeliculaoSerieRepository;
import ar.com.alk.disney.model.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PeliculaoSerieServices implements Services<PeliculaoSerieDTO, PeliculaoSerie> {


    private PeliculaoSerieMapper peliculaoSerieMapper = PeliculaoSerieMapper.MAPPER;
    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    private AvoidingMappingContext context;
    @Autowired
    private PeliculaoSerieRepository peliculaoSerieRepository;
    @Autowired
    private PersonajeRepository personajeRepository;


    @Override
    public PeliculaoSerieDTO createNew(PeliculaoSerieDTO dto) {
        return null;
    }

    //creacion


    public PeliculaoSerieDTO createNew(PeliculaoSerieDTO dto, Long id) {

        Personaje personaje = personajeRepository
                .findById(id)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Personaje", id));

        PeliculaoSerie peliculaoSerieToSave = peliculaoSerieMapper.toEntity(dto, context);

        peliculaoSerieToSave.setPersonajes(personaje);//requiere de una Lista

        peliculaoSerieRepository.save(peliculaoSerieToSave);

        PeliculaoSerieDTO peliculaoserieSaved = peliculaoSerieMapper.toDTO(peliculaoSerieToSave, context);

        return peliculaoserieSaved;

    }

    //listar todos
    @Override
    public List<PeliculaoSerieDTO> getAll() {
        // llamar al repositorio y pedirle que haga la consulta a la BD de todos los registro de de esa entidad
        List<PeliculaoSerie> peliculaSerieList = peliculaoSerieRepository.findAll();// => select * from

        // convertir esa lista de DAO a una lista de DTO
        //List<D> toDTO(List<E> entityList, @Context AvoidingMappingContext context);
        List<PeliculaoSerieDTO> peliculasoseries = peliculaoSerieMapper.toDTO(peliculaSerieList, context);
        return peliculasoseries;
    }




    //listar por Id
    @Override
    public PeliculaoSerieDTO getById(Long id) {


        Optional<PeliculaoSerie> peliculaoSerieOptional = peliculaoSerieRepository.findById(id);

        PeliculaoSerie peliculaoSerie = peliculaoSerieOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("PeliculaoSerie", id));

        PeliculaoSerieDTO peliculaoSerieDTO = peliculaoSerieMapper.toDTO(peliculaoSerie, context);

        return peliculaoSerieDTO;

    }

    @Override
    public PeliculaoSerieDTO update(PeliculaoSerieDTO dto, Long id) {


        return null;
    }

    //Actualizar

    public PeliculaoSerieDTO update(PeliculaoSerieDTO dto, Long personajeId, Long peliculaoSerieId) {

     PeliculaoSerie peliculaoSerieByIdFromDB=peliculaoSerieRepository.findById(peliculaoSerieId)
             .orElseThrow(()->logicExceptionComponent.getExceptionEntityNotFound("PeliculaoSerie", peliculaoSerieId));


      Personaje PersonajeByIdFromDB=personajeRepository.findById(personajeId)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Personaje", personajeId));


     peliculaoSerieByIdFromDB.setPersonajes(PersonajeByIdFromDB);//me dice que requiere de una lista

        mergeData(peliculaoSerieByIdFromDB, dto);

        peliculaoSerieRepository.save(peliculaoSerieByIdFromDB);

        PeliculaoSerieDTO peliculaoserieUpdated = peliculaoSerieMapper.toDTO(peliculaoSerieByIdFromDB, context);

        return peliculaoserieUpdated;


    }

    //borrar all
    @Override
    public void remove(Long id) {
        Optional<PeliculaoSerie> peliculaoSerieByIdToDelete = peliculaoSerieRepository.findById(id);
        PeliculaoSerie peliculaoSerie = peliculaoSerieByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("PeliculaoSerie", id));
        peliculaoSerieRepository.delete(peliculaoSerie);
    }


    @Override
    //Fusionar: si desea guardar sus modificaciones en cualquier momento sin conocer el estado
    // de una sesión, utilice merge () en hibernación.
    public void mergeData(PeliculaoSerie entity, PeliculaoSerieDTO dto) {
        if (dto.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("PeliculaoSerie");

        if (!entity.getImagenUrl().equals(dto.getImagenUrl()))
            entity.setImagenUrl(dto.getImagenUrl());
        if (!entity.getTitulo().equals(dto.getTituto()))
            entity.setTitulo(dto.getTituto());
        if (!entity.getFechaDeCreacion().equals(dto.getFechaDeCreacion()))
            entity.setFechaDeCreacion(dto.getFechaDeCreacion());
        if (!entity.getCalificacion().equals(dto.getCalificacion()))
            entity.setCalificacion(dto.getCalificacion());//


    }

    //borrado por Id
    public PeliculaoSerieDTO removeById(Long id) {
        Optional<PeliculaoSerie> peliculaoSerieByIdToDelete = peliculaoSerieRepository.findById(id);

        PeliculaoSerie peliculaoSerie = peliculaoSerieByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("PeliculaoSerie", id));

        peliculaoSerieRepository.delete(peliculaoSerie);
        //el mapper tranforma de entity a dto y de dto a entity
        PeliculaoSerieDTO peliculaoSerieDeleted = peliculaoSerieMapper.toDTO(peliculaoSerie, context);

        return peliculaoSerieDeleted;
    }
}

