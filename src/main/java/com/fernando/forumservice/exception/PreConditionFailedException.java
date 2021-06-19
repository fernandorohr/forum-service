package com.fernando.forumservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PreConditionFailedException extends RuntimeException {

    public PreConditionFailedException(String msg) {
        super(msg);
    }
}
