package com.example.l3.commons.exception;

import com.example.l3.commons.suberror.ApiSubError;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class OctInvalidInputException extends OctException {
    private final transient List<ApiSubError> apiSubErrors;

    public OctInvalidInputException(ErrorMessage message, ApiSubError apiSubError) {
        super(message);
        this.apiSubErrors = Collections.singletonList(apiSubError);
    }

    public OctInvalidInputException(ErrorMessage message, List<ApiSubError> apiSubErrors) {
        super(message);
        this.apiSubErrors = apiSubErrors;
    }
}

