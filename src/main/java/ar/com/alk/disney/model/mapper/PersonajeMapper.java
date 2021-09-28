package ar.com.alk.disney.model.mapper;

import ar.com.alk.disney.model.dto.PersonajeDTO;
import ar.com.alk.disney.model.entity.Personaje;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface PersonajeMapper extends DataMapper<PersonajeDTO, Personaje> {
    PersonajeMapper MAPPER = Mappers.getMapper(PersonajeMapper.class);
}
