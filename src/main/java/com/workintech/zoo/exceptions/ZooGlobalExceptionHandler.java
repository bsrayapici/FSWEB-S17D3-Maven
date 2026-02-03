package com.workintech.zoo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ZooGlobalExceptionHandler {

    @ExceptionHandler(ZooException.class)
    public ResponseEntity<ZooErrorResponse> handleZooException(ZooException ex) {
        log.error("ZooException: {}", ex.getMessage());

        ZooErrorResponse response = new ZooErrorResponse(
                ex.getMessage(),              // message
                ex.getHttpStatus().value(),   // status
                System.currentTimeMillis()    // timestamp
        );

        return new ResponseEntity<>(response, ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ZooErrorResponse> handleGenericException(Exception ex) {
        log.error("Exception: {}", ex.getMessage());

        ZooErrorResponse response = new ZooErrorResponse(
                ex.getMessage(),                // message
                HttpStatus.BAD_REQUEST.value(), // status
                System.currentTimeMillis()      // timestamp
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}