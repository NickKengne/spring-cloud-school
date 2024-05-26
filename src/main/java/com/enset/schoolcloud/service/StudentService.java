package com.enset.schoolcloud.service;


import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.RegisterDto;
import com.enset.schoolcloud.repository.StudentRepository;
import com.enset.schoolcloud.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    /*
    public String update(Integer studentId, RegisterDto registerDto) {
    }

    public String delete(Integer studentId) {
    }

    public RegisterResponse<Object> login(LoginDto loginDto) {
    }

    public RegisterResponse<Object> register(RegisterDto registerDto) {
    }

     */
}
