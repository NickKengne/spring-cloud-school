package com.enset.schoolcloud.controller;

import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.RegisterDto;
import com.enset.schoolcloud.response.AuthenticationResponse;
import com.enset.schoolcloud.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/auth" , produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse<Object>> authenticate (
        @RequestBody LoginDto request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }






}
