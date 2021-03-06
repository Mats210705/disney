package ar.com.alk.disney.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class BusinessLogicException extends RuntimeException {
    //clase que extiene de RuntimeException para lanzar una exepcion de logica de negocio.
    private String message;
    private HttpStatus httpStatus;
    private List<EntityError> entityErrors = new ArrayList<>();

    public BusinessLogicException(String message, HttpStatus httpStatus, EntityError entityError) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.entityErrors.add(entityError);
    }
}
