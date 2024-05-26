package com.enset.schoolcloud.service;

import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.RegisterDto;
import com.enset.schoolcloud.dto.TeacherRegisterDto;
import com.enset.schoolcloud.entity.Teacher;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.SectionRepository;
import com.enset.schoolcloud.repository.TeacherRepository;
import com.enset.schoolcloud.response.RegisterResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Builder
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ClassesRepository classesRepository;
    private final SectionRepository sectionRepository;

    public RegisterResponse<Object> register(TeacherRegisterDto teacherRegisterDto) {

        var current_class = classesRepository.findById(teacherRegisterDto.getClass_id()).orElseThrow(() -> new RuntimeException("No class found"));
        var current_section = sectionRepository.findById(teacherRegisterDto.getSection_id()).orElseThrow(() -> new RuntimeException("no section found"));

        Teacher teacher = Teacher.builder()
                .email(teacherRegisterDto.getEmail())
                .name(teacherRegisterDto.getName())
                .password(teacherRegisterDto.getPassword())
                .phone(teacherRegisterDto.getPhone())
                .address(teacherRegisterDto.getAddress())
                .sex(teacherRegisterDto.getSex())
                .higher_diploma(teacherRegisterDto.getHigh_diploma())
                .birthday(teacherRegisterDto.getBirthday())
                .at(teacherRegisterDto.getAt())
                .statut(teacherRegisterDto.getStatut())
                .speciality(teacherRegisterDto.getSpeciality())
                .surname(teacherRegisterDto.getSurname())
                .classe(current_class)
                .section(current_section)
                .build();
        teacherRepository.save(teacher);
        return RegisterResponse.builder()
                .created_at(Instant.now())
                .entity(teacher)
                .build();
    }

    public String delete(Integer teacher_id) {
        var current_teacher = teacherRepository.findById(teacher_id);

        if (current_teacher.isPresent())
        {
            teacherRepository.deleteById(teacher_id);
            return "teacher delete successfully";
        }
        log.info("teacher not found");
        return "teacher not found";
    }

    public String update(Integer teacher_id , RegisterDto registerDto) {
        var current_admin = teacherRepository.findById(teacher_id);

        if (current_admin.isPresent())
        {
            current_admin.get().setAddress(registerDto.getAddress());
            current_admin.get().setName(registerDto.getName());
            current_admin.get().setPhone(registerDto.getPhone());
            current_admin.get().setEmail(registerDto.getEmail());
            return "Teacher update successfully";
        }
        log.info("teacher not found");
        return "teacher not found";
    }

    public RegisterResponse<Object> login(LoginDto loginDto) {
        return RegisterResponse.builder()
                .created_at(Instant.now())
                .build();
    }
}
