package com.enset.schoolcloud.controller;

import codex.bookerapi.dto.AuthenticationDto;
import codex.bookerapi.entity.entreprise.Entreprise;
import codex.bookerapi.entity.user.User;
import codex.bookerapi.responseBody.AuthenticationResponse;
import codex.bookerapi.service.AuthenticationService;
import codex.bookerapi.dto.RegisterEntrepriseDto;
import codex.bookerapi.dto.RegisterDto;
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

    @PostMapping("/user/signup")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterDto request
    ){
        return ResponseEntity.ok(service.registerUser(request));
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/user/validate/code")
    public void activation (@RequestBody Map<String , String> activation){
        this.service.activation(activation);
    }

    // update token

    @PutMapping("/user/update/code")
    public ResponseEntity<AuthenticationResponse> updateOtp(
            @RequestBody Map<String, String> email
    )
    {
        return ResponseEntity.ok(service.updateOtp(email));
    }


    @PutMapping("/enterprise/update/code")
    public ResponseEntity<AuthenticationResponse> updateOtpEnterprise(
            @RequestBody Map<String , String> email
    )
    {
        return ResponseEntity.ok(service.updateOtpEntreprise(email));
    }

    //review method to validate an user !


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/enterprise/validate/code")
    public void activation_entreprise (@RequestBody Map<String , String> activation){
        this.service.activation_entreprise(activation);
    }


    @PostMapping("/enterprise/signup")
    public ResponseEntity<AuthenticationResponse> registerEnterprise (
            @RequestBody RegisterEntrepriseDto request
    ){
        return ResponseEntity.ok(service.registerEntreprise(request));
    }



    @PostMapping("/user/signin")
    public ResponseEntity<AuthenticationResponse> authenticate (
        @RequestBody AuthenticationDto request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }


    @PostMapping("/enterprise/signin")
    public ResponseEntity<AuthenticationResponse> authenticate_enterprise (
            @RequestBody AuthenticationDto request
    ){
        return ResponseEntity.ok(service.authenticate_enterprise(request));
    }


    @PostMapping("/user/forgot-password")
    public ResponseEntity<AuthenticationResponse> forgotPasswordUser (
            @RequestBody Map<String, String> email
    ){
        return ResponseEntity.ok(service.forgotPasswordUser(email));
    }


    @PostMapping("/enterprise/forgot-password")
    public ResponseEntity<AuthenticationResponse> forgotPasswordEnterprise (
            @RequestBody Map<String, String> email
    ){
        return ResponseEntity.ok(service.forgotPasswordEnterprise(email));
    }


    @PutMapping("/user/reset-password")
    public ResponseEntity<AuthenticationResponse> resetPasswordUser (
            @RequestBody Map<String, String> request
    ){
        return ResponseEntity.ok(service.resetPasswordUser(request));
    }


    //@PostMapping("user/logout")
    //public ResponseEntity<AuthenticationResponse> logoutUser (
      //      @RequestBody Map<String, String> request
    //){
      //  return ResponseEntity.ok(service.logoutUser(request));
    //}


    @GetMapping("/user/{id}")
    public User getUserById (
            @PathVariable("id") String user_id
    ){
        return service.getUserById(user_id);
    }


    @GetMapping("/enterprise/{entreprise_id}")
    public Entreprise getEntrepriseById (
             @PathVariable("entreprise_id") String entreprise_id
    ){
        return service.getEntrepriseById(entreprise_id);
    }

}
