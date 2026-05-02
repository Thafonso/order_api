package com.thafonsotest.users_api.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // show the exceptions to an able solution
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandartError> resourceFoundException(NotFoundException notFoundException, HttpServletRequest request){
        String error = "Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND; // error 404
        StandartError standartError = new StandartError(Instant.now(), status.value(), error, notFoundException.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standartError);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandartError> dataBase(DataBaseException notFoundException, HttpServletRequest request){
        String error = "Data Base error";
        HttpStatus status = HttpStatus.BAD_REQUEST; // This action is not allowed
        StandartError standartError = new StandartError(Instant.now(), status.value(), error, notFoundException.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standartError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValidException(MethodArgumentNotValidException notValidException, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError error = new ValidationError(status.value());

        for (FieldError fieldError : notValidException.getBindingResult().getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);
    }


}
