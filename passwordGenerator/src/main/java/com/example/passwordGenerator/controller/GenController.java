package com.example.passwordGenerator.controller;

import com.example.passwordGenerator.dto.ResponseDto;
import com.example.passwordGenerator.service.IPasswordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/passwordApi",produces = (MediaType.APPLICATION_JSON_VALUE))
@AllArgsConstructor
public class GenController {

    private IPasswordService passwordService;

    @GetMapping
    public String hello() {
        return "Hello World";
    }



    @GetMapping("/fetchPassword")
    public ResponseEntity<ResponseDto> fetchPassword(@RequestParam
                                                        String name,@RequestParam String dob) {
         ResponseDto response = new ResponseDto("200", passwordService.generatePassword(name,"12/11/1998"));
         return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/decryptPassword")
    public ResponseEntity<ResponseDto> decryptPassword(@RequestParam
                                                    String password) {
        ResponseDto response = new ResponseDto("200", passwordService.decryptPassword(password));
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }


}
