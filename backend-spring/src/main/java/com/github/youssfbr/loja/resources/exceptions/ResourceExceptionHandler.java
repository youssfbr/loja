package com.github.youssfbr.loja.resources.exceptions;

import com.github.youssfbr.loja.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(httpStatus.value());
        err.setError(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(err);
    }
}
