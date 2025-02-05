package com.example.l3.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages implements ErrorMessage {
    SUCCESS(200, "Success"),

    BAD_REQUEST(400, "Bad request"),
    INVALID_VALUE(400_001, "Invalid value"),
    SAVE_DATABASE_ERROR(400_002, "Save database error"),

    NOT_FOUND(404, "Resource not found"),
    NOT_AUTHENTICATE(32, "Authenticate failed"),
    DUPLICATE(33,"Duplicate attribute"),

    INVALID_FORMAT(34,"invalid format input"),

    INVALID_STATUS(99, "Status invalid"),
    NOT_ALLOW_UPDATE(100, "Status is not allowed to update"),
    NOT_ALLOW(101, "manager are not allowed to do this"),
    UNAUTHORIZED(401, "Unauthorized error"),
    NOT_ALLOW_LEADER(102, "this leader is not allowed to handle this")
    ;

    private final int code;
    private final String message;
}

