package com.example.l3.commons.exception;

import lombok.Getter;

@Getter
public class OctException extends RuntimeException {
    private final ErrorMessage errMsg;
    private String detail;

    public OctException(ErrorMessage errMsg) {
        super();
        this.errMsg = errMsg;
    }
    public OctException(ErrorMessage errMsg, String detail) {
        super();
        this.errMsg = errMsg;
        this.detail = detail;
    }

    public OctException() {
        super();
        errMsg = null;
    }
}

