package ar.com.alk.disney.advice;

import ar.com.alk.disney.advice.validation.RestErrorsResponse;
import ar.com.alk.disney.exception.BusinessLogicException;
import ar.com.alk.disney.exception.EntityError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessLogicExceptionHandler {
    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e, NativeWebRequest req) {

        HttpStatus httpStatus = e.getHttpStatus() != null
                ? e.getHttpStatus()
                : HttpStatus.INTERNAL_SERVER_ERROR;

        RestErrorsResponse restErrorsResponse = new RestErrorsResponse<EntityError>(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getEntityErrors()
        );

        return ResponseEntity
                .status(httpStatus)
                .body(restErrorsResponse);

    }

}
