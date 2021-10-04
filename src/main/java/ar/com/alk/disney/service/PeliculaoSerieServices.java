package ar.com.alk.disney.service;

import ar.com.alk.disney.component.BusinessLogicExceptionComponent;
import ar.com.alk.disney.model.dto.PeliculaoSerieDTO;
import ar.com.alk.disney.model.entity.PeliculaoSerie;
import ar.com.alk.disney.model.mapper.AvoidingMappingContext;
import ar.com.alk.disney.model.mapper.PeliculaoSerieMapper;
import ar.com.alk.disney.model.repository.PeliculaoSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public PeliculaoSerieDTO createNew(PeliculaoSerieDTO dto) {
        // debo hacer la conversion de dto a entity
        PeliculaoSerie peliculaoSerie = peliculaoSerieMapper.toEntity(dto, context);

        // se le pide al repository que guarde la entidad
        peliculaoSerieRepository.save(peliculaoSerie);

        // convierte a dto las instancia peliculaoserie con el id que le asigno SqlServer
        PeliculaoSerieDTO peliculaoserieSaved = peliculaoSerieMapper.toDTO(peliculaoSerie, context);

        // le entrego al controlador el dto con el id
        return peliculaoserieSaved;
    }

    @Override
    public List<PeliculaoSerieDTO> getAll() {
        // llamar al repositorio y pedirle que haga la consulta a la BD de todos los registro de de esa entidad
        List<PeliculaoSerie> peliculaSerieList = peliculaoSerieRepository.findAll();// => select * from

        // convertir esa lista de DAO a una lista de DTO
        List<PeliculaoSerieDTO> peliculaoSerieDTOS = peliculaoSerieMapper.toDTO(peliculaSerieList, context);
        return peliculaoSerieDTOS;

    }

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
        // verifico si el id existe en la base de datos
        Optional<PeliculaoSerie> peliculaoSerieOptional = peliculaoSerieRepository.findById(id);

        PeliculaoSerie peliculaoSerieById = peliculaoSerieOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("PeliculaoSerie", id));

        mergeData(peliculaoSerieById, dto);

        peliculaoSerieRepository.save(peliculaoSerieById);

        PeliculaoSerieDTO peliculaoSerieUpdated =  peliculaoSerieMapper.toDTO(peliculaoSerieById, context);

        return peliculaoSerieUpdated;
    }
    @Override
    public void remove(Long id) {
        Optional<PeliculaoSerie> peliculaoSerieByIdToDelete = peliculaoSerieRepository.findById(id);

        PeliculaoSerie peliculaoSerie = peliculaoSerieByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("PeliculaoSerie", id));

        peliculaoSerieRepository.deleteById(id);
    }

    @Override
    public void mergeData(PeliculaoSerie entity, PeliculaoSerieDTO dto) {
        if (dto.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("PeliculaoSerie");

        if (!entity.getImagen().equals(dto.getImagen()))
            entity.setTitulo(dto.getTituto());


    }

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

