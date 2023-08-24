package com.magnus.department.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMassage resurceNotFoundMethod(ResourceNotFound resourceNotFound, WebRequest request){
        ErrorMassage requestNotFoundErorMassage = new ErrorMassage(new Date(),
                HttpStatus.NOT_FOUND.value(),
                resourceNotFound.getMessage(),
                request.getDescription(false ));
        return requestNotFoundErorMassage;
    }
    @ExceptionHandler(NullOrNotMatchPostRequest.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMassage nullOrNotMatchPostRequest(NullOrNotMatchPostRequest postRequest, WebRequest request){
        ErrorMassage postErrorMassage= new ErrorMassage(new Date(),
                HttpStatus.BAD_REQUEST.value(),
                postRequest.getMessage(),
                request.getDescription(false));
        return postErrorMassage;
    }


    @ExceptionHandler(ResourceAlreadyExist.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMassage resourceAlreadyExist(ResourceAlreadyExist existResorce, WebRequest request){
        ErrorMassage postErrorMassage= new ErrorMassage(new Date(),
                HttpStatus.BAD_REQUEST.value(),
                existResorce.getMessage(),
                request.getDescription(false));
        return postErrorMassage;
    }

}
