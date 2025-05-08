package com.example.l3.commons.exception;

import com.example.l3.commons.OctResponse;
import com.example.l3.commons.suberror.ApiSubError;
import com.example.l3.commons.suberror.ApiValidatorError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class OctExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<OctResponse<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        log.info("handleMethodArgumentNotValid");

        List<ApiSubError> details = new ArrayList<>();
        ex.getBindingResult().getAllErrors()
                .forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    Object rejectValue = ((FieldError) error).getRejectedValue();
                    String message = error.getDefaultMessage();

                    details.add(new ApiValidatorError(fieldName, rejectValue, message));
                });
        return new ResponseEntity<>(OctResponse.build(ErrorMessages.INVALID_VALUE, details), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<OctResponse<String>> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.info("handleMethodArgumentTypeMismatchException. Message = {}", ex.getMessage(), ex);
        return new ResponseEntity<>(OctResponse.build(ErrorMessages.INVALID_VALUE, ex.getMessage()), HttpStatus.OK);
    }


    @ExceptionHandler(IOException.class)
    protected ResponseEntity<OctResponse<String>> handleIOException(IOException ex) {
        log.info("handleIOException. Message = {}", ex.getMessage(), ex);
        return new ResponseEntity<>(OctResponse.build(ErrorMessages.INVALID_FORMAT, ex.getMessage()), HttpStatus.OK);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<OctResponse<String>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        if (ex.getCause() instanceof DateTimeParseException && ex.getCause() instanceof IOException) {
            return new ResponseEntity<>(OctResponse.build(ErrorMessages.INVALID_FORMAT, ex.getMessage()), HttpStatus.OK);
        }
        log.info("handleHttpMessageNotReadable. Message = {}", ex.getMessage(), ex);
        return new ResponseEntity<>(OctResponse.build(ErrorMessages.INVALID_VALUE, ex.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<OctResponse<String>> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        log.info("handleNoHandlerFoundException. Message = {}", ex.getMessage(), ex);
        return new ResponseEntity<>(OctResponse.build(ErrorMessages.NOT_FOUND), HttpStatus.OK);
    }

    @ExceptionHandler(OctException.class)
    protected ResponseEntity<OctResponse<String>> handleOctException(OctException ex) {
        log.info("handleOctException. Msg = {}", ex.getErrMsg().getMessage(), ex);
        return buildResponseEntity(ex);
    }

    @ExceptionHandler(OctEntityNotFoundException.class)
    protected ResponseEntity<OctResponse<String>> handleOctEntityNotFound(OctEntityNotFoundException ex) {
        log.info("handleOctEntityNotFound. Msg = {}", ex.getErrMsg().getMessage(), ex);
        return new ResponseEntity<>(OctResponse.build(ex.getErrMsg(), Collections.singletonList(ex.getApiMessageError())), HttpStatus.OK);
    }

    @ExceptionHandler(OctInvalidInputException.class)
    protected ResponseEntity<OctResponse<String>> handleInvalidInputRequest(OctInvalidInputException ex) {
        log.info("handleInvalidInputRequest. Msg = {}", ex.getErrMsg().getMessage(), ex);
        return new ResponseEntity<>(OctResponse.build(ex.getErrMsg(), ex.getApiSubErrors()), HttpStatus.OK);
    }

    private ResponseEntity<OctResponse<String>> buildResponseEntity(OctException ex) {
        return new ResponseEntity<>(OctResponse.buildApplicationException(ex), HttpStatus.OK);
    }
}
