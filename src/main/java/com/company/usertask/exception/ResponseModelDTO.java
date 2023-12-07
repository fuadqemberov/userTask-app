package com.company.usertask.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResponseModelDTO<T> {
    private String message;
    private T data;
    private T error;

    public ResponseModelDTO(String message, T data, T error) {
        this.message = message;
        this.data = data;
        this.error = error;
    }

}
