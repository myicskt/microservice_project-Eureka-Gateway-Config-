package com.magnus.department.exceptionHandler;

public class ResourceAlreadyExist extends RuntimeException{

    public ResourceAlreadyExist(String massage){
        super(massage);
    }
}
