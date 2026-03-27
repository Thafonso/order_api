package com.thafonsotest.users_api.controller.exceptions;

import com.thafonsotest.users_api.services.exceptions.DataBaseException;
import com.thafonsotest.users_api.services.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        HttpStatus status = HttpStatus.BAD_REQUEST; // its not possible to do this action
        StandartError standartError = new StandartError(Instant.now(), status.value(), error, notFoundException.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standartError);
    }


}
