package ar.com.alk.disney.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EntityError {
    //clase que contiene la informacion de una exepcion de logica de negocio.
    private String entity;
    private String message;
}
