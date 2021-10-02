package ar.com.alk.disney.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PersonajeDTO implements Serializable {

    @NotBlank(message = "Imagen es requerida")
    private String imagen;

    @NotBlank(message = "Nombre es requerido")
    private String nombre;


}
