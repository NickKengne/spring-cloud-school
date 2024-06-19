package com.enset.schoolcloud.service;

import com.enset.schoolcloud.config.JwtService;
import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.repository.AdminRepository;
import com.enset.schoolcloud.repository.TeacherRepository;
import com.enset.schoolcloud.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService  {

    private final AdminRepository adminRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TeacherRepository teacherRepository;


    public AuthenticationResponse<Object> authenticate(LoginDto request) {
        var user = adminRepository.findByEmail((request.getEmail()));
        var user_in_teacher = teacherRepository.findByEmail(request.getEmail());


        // verify if user is verified or not
        if (user.isEmpty() || user_in_teacher.isEmpty()){
            return AuthenticationResponse.builder()
                    .success(false)
                    .message("User doesn't exist !")
                    .error(true)
                    .build();
        }
        else {
                // left spring to authenticate my user
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );
                //create a jwtToken
                var jwtToken = jwtService.generateToken(user.get());
                return AuthenticationResponse.builder()
                        .error(false)
                        .message(user.get().getName() + " " + " is connected successfully")
                        .token(jwtToken)
                        .success(true)
                        .id(user.get().getAdmin_id())
                        .user(user_in_teacher.get())
                        .build();
        }

    }


    //public AuthenticationResponse logoutUser(Map<String, String> request) {
    //}
}