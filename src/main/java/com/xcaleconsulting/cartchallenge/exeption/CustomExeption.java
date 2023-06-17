package com.xcaleconsulting.cartchallenge.exeption;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomExeption extends RuntimeException {
    private String code;
    private HttpStatus status;

    public CustomExeption(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
