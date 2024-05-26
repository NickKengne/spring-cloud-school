package com.enset.schoolcloud.service;




import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.RegisterDto;
import com.enset.schoolcloud.entity.Admin;
import com.enset.schoolcloud.repository.AdminRepository;
import com.enset.schoolcloud.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final AdminRepository adminRepository;

    public RegisterResponse<Object> register(RegisterDto registerDto) {
        Admin admin = Admin.builder()
                .email(registerDto.getEmail())
                .name(registerDto.getName())
                .password(registerDto.getPassword())
                .phone(registerDto.getPhone())
                .address(registerDto.getAddress())
                .build();
        adminRepository.save(admin);
        return RegisterResponse.builder()
                .created_at(Instant.now())
                .entity(admin)
                .build();
    }

    public RegisterResponse<Object> login(LoginDto loginDto) {
        return RegisterResponse.builder()
                .created_at(Instant.now())
                .build();
    }

    public String delete(Integer adminId) {
        var current_admin = adminRepository.findById(adminId);

        if (current_admin.isPresent())
        {
            adminRepository.deleteById(adminId);
            return "Admin delete successfully";
        }
        log.info("admin not found");
        return "admin not found";
    }

    public String update(Integer adminId, RegisterDto registerDto) {
        var current_admin = adminRepository.findById(adminId);

        if (current_admin.isPresent())
        {
            current_admin.get().setAddress(registerDto.getAddress());
            current_admin.get().setName(registerDto.getName());
            current_admin.get().setPhone(registerDto.getPhone());
            current_admin.get().setEmail(registerDto.getEmail());
            return "Admin update successfully";
        }
        log.info("admin not found");
        return "admin not found";
    }
}