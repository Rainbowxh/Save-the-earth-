package com.example.finalpaper.Entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Data
public class apiError {
    private HttpStatus status;
    private String message;
    private String reason;
    private List<String> errors;

    public apiError(HttpStatus status, String message,String reason, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.reason = reason;
    }

    public apiError(HttpStatus status, String message, String reason) {
        super();
        this.status = status;
        this.message = message;
        this.reason = reason;
    }
}
