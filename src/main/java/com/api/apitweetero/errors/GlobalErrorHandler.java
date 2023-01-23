package com.api.apitweetero.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors =  ex.getFieldErrors().stream().map(error -> String.format("Field[%s] %s",error.getField(), error.getDefaultMessage())).toList();
        return new ResponseEntity<>(getErrorMap(errors.get(0)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String, String>> ConflictError(ConflictException ex) {
        return new ResponseEntity<>(getErrorMap(ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> NotFoundError(NotFoundException ex) {
        return new ResponseEntity<>(getErrorMap(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    private Map<String, String> getErrorMap(String error) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", error);
        return errorResponse;
    }
}


