package ipss.cl.apis70.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ipss.cl.apis70.responses.VideojuegoResponse;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(value = RuntimeException.class)
  public ResponseEntity<Object> RuntimeExceptionHeadler(RuntimeException ex) {
    VideojuegoResponse videojuegoResponse = new VideojuegoResponse();

    videojuegoResponse.setStatus(400);
    videojuegoResponse.setMessage(ex.getMessage());

    return ResponseEntity.badRequest()
        .body(videojuegoResponse);
  }

}
