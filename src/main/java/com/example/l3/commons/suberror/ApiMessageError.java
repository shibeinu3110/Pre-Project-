package com.example.l3.commons.suberror;

import lombok.Getter;

@Getter
public class ApiMessageError implements ApiSubError {
    private final String errorMessage;

    public ApiMessageError(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

