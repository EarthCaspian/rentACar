package com.tobeto.rentACar.core.exceptions;

import com.tobeto.rentACar.core.exceptions.types.BusinessException;
import com.tobeto.rentACar.core.exceptions.types.NotFoundException;
import com.tobeto.rentACar.core.utilities.results.ErrorResult;
import com.tobeto.rentACar.core.utilities.results.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBusinessException(BusinessException exception)
    {
        return new ErrorResult(exception.getMessage());
    }

    // 404 not found
    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleNotFoundException(NotFoundException exception){
        return new ErrorResult(exception.getMessage());
    }


    // TODO
    // Result yapısı ve multi-language.
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleValidationException(MethodArgumentNotValidException exception){
        // gelen exceptiondaki validasyon hatalarını oku liste olarak kullanıcıya göster
        Map<String,String> errors = new HashMap<>();

        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        // DATA
        // Validasyon hataları mevcut.
        return errors;
    }

}
