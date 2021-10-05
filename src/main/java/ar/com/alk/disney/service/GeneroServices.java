package ar.com.alk.disney.service;

import ar.com.alk.disney.component.BusinessLogicExceptionComponent;
import ar.com.alk.disney.model.dto.GeneroDTO;
import ar.com.alk.disney.model.dto.PeliculaoSerieDTO;
import ar.com.alk.disney.model.dto.PersonajeDTO;
import ar.com.alk.disney.model.entity.Genero;
import ar.com.alk.disney.model.entity.PeliculaoSerie;
import ar.com.alk.disney.model.mapper.AvoidingMappingContext;
import ar.com.alk.disney.model.mapper.GeneroMapper;
import ar.com.alk.disney.model.mapper.PeliculaoSerieMapper;
import ar.com.alk.disney.model.repository.GeneroRepository;
import ar.com.alk.disney.model.repository.PeliculaoSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServices implements Services<GeneroDTO, Genero> {
    @Autowired
    private GeneroMapper generoMapper= GeneroMapper.MAPPER;
    @Autowired
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired
    private AvoidingMappingContext context;
    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    private PeliculaoSerieRepository peliculaoSerieRepository;






   @Override
   public GeneroDTO createNew(GeneroDTO dto) {
        return null;
    }

    public GeneroDTO createNew(GeneroDTO dto, Long id) {
        Genero genero=generoRepository
                .findById(id)
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Genero" , id));
        Genero generoToSave=generoMapper.toEntity(dto,context);
        generoToSave.setPeliculaoSeries(peliculaoSerie);

        return generoToSave;
    }

    @Override
    public List<GeneroDTO> getAll() {
        return null;
    }

    @Override
    public GeneroDTO getById(Long id) {
        return null;
    }

    @Override
    public GeneroDTO update(GeneroDTO dto, Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void mergeData(Genero entity, GeneroDTO dto) {

    }
}
