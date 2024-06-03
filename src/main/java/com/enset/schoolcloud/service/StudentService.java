package com.enset.schoolcloud.service;


import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.StudentRegisterDto;
import com.enset.schoolcloud.repository.StudentRepository;
import com.enset.schoolcloud.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public String update(Integer studentId, StudentRegisterDto StudentRegisterDto){
        return "";
    }

    public String delete(Integer studentId) {
        return "";
    }

    public RegisterResponse<Object> login(LoginDto loginDto) {
        return RegisterResponse.builder()
                .created_at(Instant.now())
                .build();
    }

    public RegisterResponse<Object> register(StudentRegisterDto StudentRegisterDto) {
        return RegisterResponse.builder()
                .created_at(Instant.now())
                .build();
    }


}
