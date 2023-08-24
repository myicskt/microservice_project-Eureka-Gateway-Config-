package com.magnus.employee.exceptionHandler;

public class ResourceAlreadyExist extends RuntimeException{

    public ResourceAlreadyExist(String massage){
        super(massage);
    }
}
