package com.turkcell.flightmanagementsystem.core.exception.type;

//global exception handlerin olduğunu söyleyeceğiz
//RestControllerin hatalarının danıiacağı yer burası

import com.turkcell.flightmanagementsystem.core.exception.result.BusinessExceptionResult;
import com.turkcell.flightmanagementsystem.core.exception.result.ExceptionResult;
import com.turkcell.flightmanagementsystem.core.exception.result.ValidationExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //İş Kuralları hataları
    @ExceptionHandler({Exception.class})
    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResult handleException(Exception e) {return new ExceptionResult("Internal Server Error");}

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessExceptionResult handlerRuntimeException(BusinessException e) {
        return new BusinessExceptionResult(e.getMessage());
    }
    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<List<String>> validationException(ValidationException e) {
        return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationExceptionResult handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ValidationExceptionResult(e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map((error) ->error.getDefaultMessage())
                .toList());
    }



}
