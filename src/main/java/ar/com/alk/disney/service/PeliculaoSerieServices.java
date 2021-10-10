package ar.com.alk.disney.service;

import ar.com.alk.disney.component.BusinessLogicExceptionComponent;
import ar.com.alk.disney.model.dto.GeneroDTO;
import ar.com.alk.disney.model.dto.PeliculaoSerieDTO;

import ar.com.alk.disney.model.entity.Genero;
import ar.com.alk.disney.model.entity.PeliculaoSerie;

import ar.com.alk.disney.model.entity.Personaje;
import ar.com.alk.disney.model.mapper.AvoidingMappingContext;
import ar.com.alk.disney.model.mapper.PeliculaoSerieMapper;
import ar.com.alk.disney.model.repository.PeliculaoSerieRepository;
import ar.com.alk.disney.model.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PeliculaoSerieServices implements Services<PeliculaoSerieDTO, PeliculaoSerie> {

    @Autowired
    private PeliculaoSerieMapper peliculaoSerieMapper = PeliculaoSerieMapper.MAPPER;
    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    private AvoidingMappingContext context;
    @Autowired
    private PeliculaoSerieRepository peliculaoSerieRepository;
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PersonajeRepository generoRepository;

    @Override
    public PeliculaoSerieDTO createNew(PeliculaoSerieDTO dto){
        return null;
    }

   //creacion

    public PeliculaoSerieDTO createNew(PeliculaoSerieDTO dto ) {

    return  null;



    }
    //listar todos
    @Override
    public List<PeliculaoSerieDTO> getAll(){
        // llamar al repositorio y pedirle que haga la consulta a la BD de todos los registro de de esa entidad
        List<PeliculaoSerie> peliculaSerieList = peliculaoSerieRepository.findAll();// => select * from

        // convertir esa lista de DAO a una lista de DTO
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
    //Actualizar
    @Override
    public PeliculaoSerieDTO update(PeliculaoSerieDTO dto, Long id) {
        // verifico si el id existe en la base de datos
        Optional<PeliculaoSerie> peliculaoSerieOptional = peliculaoSerieRepository.findById(id);

        PeliculaoSerie peliculaoSerieById = peliculaoSerieOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("PeliculaoSerie", id));

        mergeData(peliculaoSerieById, dto);

        peliculaoSerieRepository.save(peliculaoSerieById);

        PeliculaoSerieDTO peliculaoSerieUpdated =  peliculaoSerieMapper.toDTO(peliculaoSerieById, context);

        return peliculaoSerieUpdated;
    }
    //borrar todo
    @Override
    public void remove(Long id) {
        Optional<PeliculaoSerie> peliculaoSerieByIdToDelete = peliculaoSerieRepository.findById(id);

        PeliculaoSerie peliculaoSerie = peliculaoSerieByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("PeliculaoSerie", id));

        peliculaoSerieRepository.deleteById(id);
    }

    @Override
    //Fusionar: si desea guardar sus modificaciones en cualquier momento sin conocer el estado
    // de una sesión, utilice merge () en hibernación.
    public void mergeData(PeliculaoSerie entity, PeliculaoSerieDTO dto) {
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

