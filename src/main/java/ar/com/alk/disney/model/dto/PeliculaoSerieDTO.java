package ar.com.alk.disney.model.dto;

import ar.com.alk.disney.model.entity.Personaje;
import lombok.*;

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
    @NotBlank(message = "Imagen es requerida")
    private String imagen;
    @NotBlank(message = "Titulo es requerido")
    private String tituto;
    @NotBlank(message = "Fecha de creación es requerida")
    private Date fechaDeCreacion;


    List<PersonajeDTO>Personaje;

    List<GeneroDTO>Genero;

    public Boolean hasNullOrEmptyAttributes() {
        return tituto == null || tituto.trim().isEmpty();
    }



}
