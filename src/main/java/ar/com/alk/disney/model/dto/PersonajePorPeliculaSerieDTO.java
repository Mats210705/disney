package ar.com.alk.disney.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonajePorPeliculaSerieDTO implements Serializable {
    @NotBlank(message = "Nombre es requerido")
    private String nombre;
    @NotBlank(message = "Imagen es requerida")
    private String imagenUrl;
    @NotBlank(message = "Edad es requerida")
    private Integer edad;
    @NotBlank(message = "Peso es requerido")
    private float peso;
    @NotBlank(message = "Historia es requerida")
    private String historia;
    //todos los objetos de personajes + collections de PeliculaoSerie

    @JsonIgnoreProperties({ "generos" , "personajes"})
    private PeliculaoSerieDTO peliculaoSeries;
}
