package ar.com.alk.disney.model.dto;


import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;


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
    private String imagen;
    @NotBlank(message = "Edad es requerida")
    private Integer edad;
    @NotNull(message = "Peso es requerido")
    private Float peso;
    @NotBlank(message = "Historia es requerida")
    private String historia;

    public Boolean hasNullOrEmptyAttributes() {
        return nombre == null || nombre.trim().isEmpty()
                || imagen == null || imagen.trim().isEmpty()
                || edad == null
                 || peso==null
                || historia == null || historia.trim().isEmpty();

    }
}

