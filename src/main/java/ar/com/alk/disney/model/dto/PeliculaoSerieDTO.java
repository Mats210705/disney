package ar.com.alk.disney.model.dto;

import ar.com.alk.disney.model.entity.Personaje;
import lombok.*;
import sun.util.calendar.BaseCalendar;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PeliculaoSerieDTO implements Serializable{

    private Long id;
    private String imagen;
    @NotBlank(message = "is required")////ver error
    private String tituto;
    private Date fechaDeCreacion;
    private Integer Calificacion;

    List<PersonajeDTO>Personaje;

    List<GeneroDTO>Genero;

    public Boolean hasNullOrEmptyAttributes() {
        return titulo == null || titulo.trim().isEmpty();
    }



}
