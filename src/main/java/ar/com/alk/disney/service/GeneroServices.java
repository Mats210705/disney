package ar.com.alk.disney.service;

import ar.com.alk.disney.component.BusinessLogicExceptionComponent;
import ar.com.alk.disney.model.dto.GeneroDTO;

import ar.com.alk.disney.model.entity.Genero;

import ar.com.alk.disney.model.mapper.AvoidingMappingContext;
import ar.com.alk.disney.model.mapper.GeneroMapper;
import ar.com.alk.disney.model.repository.GeneroRepository;
import ar.com.alk.disney.model.repository.PeliculaoSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Genero genero= generoMapper.toEntity(dto, context);
        generoRepository.save(genero);
        GeneroDTO generoSaved = generoMapper.toDTO(genero, context);
        return generoSaved;
    }

    @Override
    public List<GeneroDTO> getAll() {
        List<Genero> generoList = generoRepository.findAll();// => select * from

        // convertir esa lista de DAO a una lista de DTO
        List<GeneroDTO> generos = generoMapper.toDTO(generoList, context);
        return generos;
    }

    @Override
    public GeneroDTO getById(Long id) {
        Optional<Genero> generoOptional = generoRepository.findById(id);

        Genero genero = generoOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Genero", id));

        GeneroDTO generoDTO = generoMapper.toDTO(genero, context);

        return generoDTO;
    }

    @Override
    public GeneroDTO update(GeneroDTO dto, Long id) {
        Optional<Genero> generoOptional = generoRepository.findById(id);

        Genero generoById = generoOptional
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Genero", id));

        mergeData(generoById, dto);

        generoRepository.save(generoById);

        GeneroDTO generotUpdated = generoMapper.toDTO(generoById, context);

        return generotUpdated;
    }

    @Override
    public GeneroDTO remove(Long id) {
        Optional<Genero> generoByIdToDelete = generoRepository.findById(id);

        Genero genero = generoByIdToDelete
                .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Genero", id));

        generoRepository.deleteById(id);
        GeneroDTO generoDeleted = generoMapper.toDTO(genero, context);

        return generoDeleted;

    }

    @Override
    public void mergeData(Genero entity, GeneroDTO dto) {
        if (dto.hasNullOrEmptyAttributes())
            throw logicExceptionComponent.getExceptionEntityEmptyValues("Genero");

        if (!entity.getNombre().equals(dto.getNombre()))
            entity.setNombre(dto.getNombre());
        if (!entity.getImagenUrl().equals(dto.getNombre()))
            entity.setImagenUrl(dto.getImagenUrl());

    }
    //public GeneroDTO removeById(Long id) {
       // Optional<Genero> generoByIdToDelete = generoRepository.findById(id);

       // Genero genero = generoByIdToDelete
        //        .orElseThrow(() -> logicExceptionComponent.getExceptionEntityNotFound("Genero", id));

       // generoRepository.delete(genero);

       // GeneroDTO generoDeleted = generoMapper.toDTO(genero, context);

       // return generoDeleted;
   // }
}
