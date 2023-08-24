package com.magnus.department.exceptionHandler;

public class NullOrNotMatchPostRequest extends RuntimeException{


    public NullOrNotMatchPostRequest(String massage ){
        super(massage) ;
    }
}
