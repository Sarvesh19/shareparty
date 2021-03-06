package com.shareparty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
   @ExceptionHandler(value = RecordNotFoundException.class)
   public ResponseEntity<Object> exception(RecordNotFoundException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
   }
   
   
   @ExceptionHandler(value = RequestAlreadySentException.class)
   public ResponseEntity<Object> exception(RequestAlreadySentException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
   }
}