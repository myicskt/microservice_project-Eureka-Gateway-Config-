package com.magnus.department.exceptionHandler;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String massage){
        super(massage);
    }
}
