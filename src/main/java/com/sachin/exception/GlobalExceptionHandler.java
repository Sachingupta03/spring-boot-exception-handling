package com.sachin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFoundException ex) {
        Map<String, Object> error = new LinkedHashMap<> ();
        error.put ("timestamp", LocalDateTime.now ());
        error.put ("status", HttpStatus.NOT_FOUND.value ());
        error.put ("error", HttpStatus.NOT_FOUND.getReasonPhrase ());
        error.put ("message", ex.getMessage ());
        return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNameNotFoundException ex) {
        Map<String, Object> error = new LinkedHashMap<> ();
        error.put ("timestamp", LocalDateTime.now ());
        error.put ("status", HttpStatus.NOT_FOUND.value ());
        error.put ("error", HttpStatus.NOT_FOUND.getReasonPhrase ());
        error.put ("message", ex.getMessage ());
        return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UserEmailNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserEmailNotFound(UserEmailNotFoundException ex) {
        Map<String, Object> error = new LinkedHashMap<> ();
        error.put ("timestamp", LocalDateTime.now ());
        error.put ("status", HttpStatus.NOT_FOUND.value ());
        error.put ("error", HttpStatus.NOT_FOUND.getReasonPhrase ());
        error.put ("message", ex.getMessage ());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}






