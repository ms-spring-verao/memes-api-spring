package br.usp.ime.verao.backend.Memes.Advices;

import br.usp.ime.verao.backend.Memes.Exceptions.EntityValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EntityValidationAdvice {
    @ResponseBody
    @ExceptionHandler(EntityValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String, String> entityValidationHandler(EntityValidationException ex) {
        Map<String, String> resp = new HashMap<>();

        resp.put("error", ex.getMessage()); // { "error": "name is invalid" }

        return resp;
    }
}
