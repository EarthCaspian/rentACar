package com.tobeto.rentACar.core.utilities.exceptions.globalexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException) {
        return new ProblemDetails(businessException.getMessage(), "BUSINESS_ERROR");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
        validationProblemDetails.setErrorCode("VALIDATION_ERROR");

        validationProblemDetails.setValidationErrors(new HashMap<>());

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return validationProblemDetails;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleException(Exception exception) {
        return new ProblemDetails(exception.getMessage(), "INTERNAL_SERVER_ERROR");
    }
}
