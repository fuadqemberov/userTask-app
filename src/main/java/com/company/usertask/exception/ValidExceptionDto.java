package com.company.usertask.exception;

import lombok.AllArgsConstructor;
import lombok.Data;



    @Data
    @AllArgsConstructor
    public class ValidExceptionDto {
    private String property;
    private String message;

}