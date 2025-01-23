package com.bandas.Bandas.config;

import com.bandas.Bandas.dto.ErrorDto;
import com.bandas.Bandas.exceptions.AppException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> response(AppException exception){
        return ResponseEntity
                .status(exception.getStatus())
                .body(new ErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> responseEntity(ConstraintViolationException exception){
        String errorMensaje = "Error de validación: " + exception.getConstraintViolations()
                .stream()
                .map(constraintViolation -> constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity.badRequest().body(new ErrorDto(errorMensaje));
    }

}
