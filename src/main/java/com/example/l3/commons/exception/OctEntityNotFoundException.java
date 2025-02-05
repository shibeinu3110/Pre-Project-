package com.example.l3.commons.exception;

import com.example.l3.commons.suberror.ApiMessageError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OctEntityNotFoundException extends OctException {
    private final ApiMessageError apiMessageError;

    public OctEntityNotFoundException(ErrorMessage message, ApiMessageError apiMessageError) {
        super(message);
        this.apiMessageError = apiMessageError;
    }
}

