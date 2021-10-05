package ar.com.alk.disney.model.dto;

import ar.com.alk.disney.model.entity.PeliculaoSerie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonajePorPeliculaSerieDTO {
    @NotBlank(message = "Nombre es requerido")
    private String nombre;
    @NotBlank(message = "Imagen es requerida")
    private String imagen;
    @NotBlank(message = "Edad es requerida")
    private Integer edad;
    @NotBlank(message = "Peso es requerido")
    private float peso;
    @NotBlank(message = "Historia es requerida")
    private String historia;
    private Set<PeliculaoSerie> peliculaoSerie;
}
