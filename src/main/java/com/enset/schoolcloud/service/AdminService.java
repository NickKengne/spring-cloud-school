package com.enset.schoolcloud.service;




import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.RegisterDto;
import com.enset.schoolcloud.entity.Admin;
import com.enset.schoolcloud.entity.Teacher;
import com.enset.schoolcloud.repository.AdminRepository;
import com.enset.schoolcloud.repository.TeacherRepository;
import com.enset.schoolcloud.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final TeacherRepository teacherRepository;

    public RegisterResponse<Object> register(RegisterDto registerDto) {
        Admin admin = Admin.builder()
                .email(registerDto.getEmail())
                .name(registerDto.getName())
                .password(passwordEncoder.encode((registerDto.getPassword())))
                .phone(registerDto.getPhone())
                .address(registerDto.getAddress())
                .type(Admin.Role.ADMIN)
                .build();

        Teacher teacher = Teacher.builder()
                .email(registerDto.getEmail())
                .surname(registerDto.getSurname())
                .name(registerDto.getName())
                .password(passwordEncoder.encode((registerDto.getPassword())))
                .phone(registerDto.getPhone())
                .address(registerDto.getAddress())
                .sex(registerDto.getSex())
                .at(registerDto.getAt())
                .birthday(registerDto.getBirthday())
                .higher_diploma(registerDto.getHigher_diploma())
                .statut(registerDto.getStatut())
                .type("admin")
                .build();

        var user_in_admin = adminRepository.findByEmail(registerDto.getEmail());
        var user_in_teacher = teacherRepository.findByEmail(registerDto.getEmail());
        if (user_in_admin.isPresent() || user_in_teacher.isPresent()){
            RegisterResponse.builder()
                    .created_at(Instant.now())
                    .message("Email already exists !")
                    .error(true)
                    .success(false)
                    .entity(null)
                    .build();
        }
       else {
            teacherRepository.save(teacher);
            adminRepository.save(admin);
            return RegisterResponse.builder()
                    .created_at(Instant.now())
                    .entity(admin)
                    .success(true)
                    .message("User created successfully !")
                    .build();
        }
        return null;
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