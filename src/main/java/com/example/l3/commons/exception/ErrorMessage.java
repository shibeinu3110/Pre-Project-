package com.example.l3.commons.exception;

import java.io.Serializable;

public interface ErrorMessage extends Serializable {

    int getCode();

    String getMessage();
}
