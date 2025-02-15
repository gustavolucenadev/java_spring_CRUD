package com.challenge.crud.crud.controllers.handlers;

import com.challenge.crud.crud.dto.CustomError;

import com.challenge.crud.crud.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.crypto.Data;
import java.lang.reflect.Method;
import java.time.Instant;
@ControllerAdvice
public class ControllerExceptionHandler {
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {HttpStatus status = HttpStatus.NOT_FOUND;
            CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }

}
