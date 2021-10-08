package ar.com.alk.disney.model.dto;

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

public class PersonajePresentacionDTO implements Serializable {

    @NotBlank(message = "Imagen es requerida")
    private String imagen;

    @NotBlank(message = "Nombre es requerido")
    private String nombre;


}

