package ar.com.alk.disney.model.mapper;

import ar.com.alk.disney.model.dto.PeliculaoSerieDTO;
import ar.com.alk.disney.model.entity.PeliculaoSerie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PeliculaoSerieMapper extends DataMapper<PeliculaoSerieDTO, PeliculaoSerie> {

    PeliculaoSerieMapper MAPPER= Mappers.getMapper(PeliculaoSerieMapper.class);

}
