package com.magnus.employee.exceptionHandler;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String massage){
        super(massage);
    }
}
