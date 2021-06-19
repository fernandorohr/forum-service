package com.fernando.forumservice.handler;

import com.fernando.forumservice.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException exception) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .title("Bad Request")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .details(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PreConditionFailedException.class)
    public ResponseEntity<PreConditionFailedExceptionDetails> handlerPreConditionFailedException(
                                                                PreConditionFailedException exception) {
        return new ResponseEntity<>(
                PreConditionFailedExceptionDetails.builder()
                        .title("Pre-Condition Failed")
                        .status(HttpStatus.PRECONDITION_FAILED.value())
                        .details(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDetails> handlerNotFoundException(NotFoundException exception) {
        return new ResponseEntity<>(
                NotFoundExceptionDetails.builder()
                        .title("Pre-Condition Failed")
                        .status(HttpStatus.NOT_FOUND.value())
                        .details(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }
}
