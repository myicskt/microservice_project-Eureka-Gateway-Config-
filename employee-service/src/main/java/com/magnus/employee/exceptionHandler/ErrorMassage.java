package com.magnus.employee.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class ErrorMassage {
    private Date timeStamp;
    private int statusCode;
    private String errorMassage;
    private String path;
}
