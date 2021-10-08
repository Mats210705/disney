package ar.com.alk.disney.model.dto;

import ar.com.alk.disney.model.entity.PeliculaoSerie;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonajeDTO implements Serializable {

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

    public Boolean hasNullOrEmptyAttributes() {
        return nombre == null || nombre.trim().isEmpty()
                || imagen == null || imagen.trim().isEmpty()
                || edad == null
                || peso == null
                || historia == null || historia.trim().isEmpty();

    }
}

