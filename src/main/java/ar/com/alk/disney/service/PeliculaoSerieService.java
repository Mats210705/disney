package ar.com.alk.disney.service;

import ar.com.alk.disney.component.BusinessLogicExceptionComponent;
import ar.com.alk.disney.model.dto.PeliculaoSerieDTO;
import ar.com.alk.disney.model.entity.PeliculaoSerie;
import ar.com.alk.disney.model.mapper.AvoidingMappingContext;
import ar.com.alk.disney.model.mapper.PeliculaoSerieMapper;
import ar.com.alk.disney.model.repository.PeliculaoSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaoSerieServices implements Services<PeliculaoSerieDTO, PeliculaoSerie> {
    @Autowired
    private PeliculaoSerieMapper peliculaoSerieMapper=PeliculaoSerieMapper.MAPPER;
    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;
    @Autowired
    private AvoidingMappingContext context;

    @Autowired
    private PeliculaoSerieRepository;
    @Autowired
    public PeliculaoSerieDTO createNew(PeliculaoSerieDTO dto) {
        // debo hacer la conversion de dto a entity
        PeliculaoSerie peliculaoserie = PeliculaoSerieMapper.MAPPER.toEntity(dto, context);

        // se le pide al repository que guarde la entidad
        PeliculaoSerieRepository.save(peliculaoserie);

        // convierte a dto las instancia peliculaoserie con el id que le asigno SqlServer
        PeliculaoSerieDTO peliculaoserieSaved = peliculaoSerieMapper.toDTO(peliculaoserie, context);

        // le entrego al controlador el dto con el id
        return peliculaoserieSaved;
    }

}
