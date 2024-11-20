package com.example.passwordGenerator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorRespDto {

    private String apiPath;
    private String message;
    private HttpStatus errorCode;
    private LocalDateTime errorTime;

}
