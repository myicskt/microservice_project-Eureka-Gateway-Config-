package com.magnus.employee.exceptionHandler;

public class NullOrNotMatchPostRequest extends RuntimeException{


    public NullOrNotMatchPostRequest(String massage ){
        super(massage) ;
    }
}
