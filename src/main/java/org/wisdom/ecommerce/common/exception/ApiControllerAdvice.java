package org.wisdom.ecommerce.common.exception;

import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.wisdom.ecommerce.common.model.ErrorResponse;

@Slf4j
@RestControllerAdvice
class ApiControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception ex) {
    log.error(ex.getMessage(), ex);
    return ResponseEntity.status(500).body(new ErrorResponse(ex.getMessage()));
  }


  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
    log.error(ex.getMessage(), ex);
    return ResponseEntity.status(400).body(new ErrorResponse(ex.getMessage()));
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex) {
    log.error(ex.getMessage(), ex);
    return ResponseEntity.status(404).body(new ErrorResponse(ex.getMessage()));
  }
}
