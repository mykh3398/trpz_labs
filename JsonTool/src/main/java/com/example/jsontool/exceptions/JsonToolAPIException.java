package com.example.jsontool.exceptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class JsonToolAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}