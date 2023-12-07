package com.company.usertask.exception;

import org.springframework.http.HttpStatus;

public interface SuccessResponse {

    String getKey();

    String getMessage();

    HttpStatus getHttpStatus();
}
