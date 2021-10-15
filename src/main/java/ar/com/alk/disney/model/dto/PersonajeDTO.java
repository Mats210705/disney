package ar.com.alk.disney.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonajeDTO implements Serializable {
    private Long id;
    @NotBlank(message = "Nombre es requerido")
    private String nombre;
    @NotBlank(message = "Imagen es requerida")
    private String imagenUrl;
    @NotBlank(message = "Edad es requerida")
    private Integer edad;
    @NotNull(message = "Peso es requerido")
    private Float peso;
    @NotBlank(message = "Historia es requerida")
    private String historia;
    private List<PeliculaoSerieDTO> pelicula;

    @JsonIgnoreProperties({ "generos" , "personajes"})
    private PeliculaoSerieDTO peliculaoSeries;

    public Boolean hasNullOrEmptyAttributes() {
        return nombre == null || nombre.trim().isEmpty()
                || imagenUrl == null || imagenUrl.trim().isEmpty()
                || edad == null
                 || peso==null
                || historia == null || historia.trim().isEmpty();

    }
}

