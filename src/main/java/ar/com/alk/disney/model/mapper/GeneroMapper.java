package ar.com.alk.disney.model.mapper;

import ar.com.alk.disney.model.dto.GeneroDTO;
import ar.com.alk.disney.model.entity.Genero;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeneroMapper extends DataMapper<GeneroDTO, Genero> {
    GeneroMapper MAPPER= Mappers.getMapper(GeneroMapper.class);

}
