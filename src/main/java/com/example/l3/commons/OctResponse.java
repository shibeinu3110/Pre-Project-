package com.example.l3.commons;

import com.example.l3.commons.exception.ErrorMessage;
import com.example.l3.commons.exception.OctException;
import com.example.l3.commons.suberror.ApiSubError;
import com.example.l3.helper.DateHelper;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
public class OctResponse<T> {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateHelper.GLOBAL_DATE_TIME)
    private final LocalDateTime timestamp = LocalDateTime.now();
    private int code;
    private String message;
    private List<ApiSubError> details;
    private T data;
    private int total;

    public static <T> OctResponse<T> build(ErrorMessage errorMessage) {
        OctResponse<T> response = new OctResponse<>();
        response.code = errorMessage.getCode();
        response.message = errorMessage.getMessage();
        return response;
    }

    public static <T> OctResponse<T> build(ErrorMessage errorMessage, List<ApiSubError> details) {
        OctResponse<T> response = build(errorMessage);
        response.details = details;
        return response;
    }

    public static <T> OctResponse<T> build(T data) {
        OctResponse<T> response = new OctResponse<>();
        response.data = data;
        if (data instanceof Collection) {
            response.total = ((Collection<?>) data).size();
        }
        response.code = 200;
        return response;
    }

    public static <T> OctResponse<T> build(T data, String message) {
        OctResponse<T> response = new OctResponse<>();
        response.data = data;
        if (data instanceof Collection) {
            response.total = ((Collection<?>) data).size();
        }
        response.code = 200;
        response.message = message;
        return response;
    }

    public static <T> OctResponse<T> build(T data, Integer total) {
        OctResponse<T> response = build(data);
        response.total = total;
        return response;
    }

    public static <T> OctResponse<T> build(T data, ErrorMessage errorMessage) {
        OctResponse<T> response = build(errorMessage);
        response.data = data;
        return response;
    }

    public static <T> OctResponse<T> build(ErrorMessage errorMessage, String message) {
        OctResponse<T> response = build(errorMessage);
        response.message = message;
        return response;
    }


    public static <T> OctResponse<T> build(String message, Integer errCode) {
        OctResponse<T> response = new OctResponse<>();
        response.code = errCode;
        response.message = message;
        return response;
    }


    public static OctResponse<String> buildApplicationException(OctException exception) {
        return build(exception.getDetail(), exception.getErrMsg());
    }
}

