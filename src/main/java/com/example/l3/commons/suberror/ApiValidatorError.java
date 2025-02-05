package com.example.l3.commons.suberror;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiValidatorError implements ApiSubError {
    private String field;
    private Object rejectValue;
    private String message;
}

