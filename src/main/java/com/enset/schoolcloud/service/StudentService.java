package com.enset.schoolcloud.service;


import com.enset.schoolcloud.dto.EnrollDto;
import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.StudentRegisterDto;
import com.enset.schoolcloud.entity.Enroll;
import com.enset.schoolcloud.entity.Student;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.EnrollRepository;
import com.enset.schoolcloud.repository.StudentRepository;
import com.enset.schoolcloud.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final EnrollRepository enrollRepository;
    private final ClassesRepository classesRepository;


    public String update(Integer studentId, StudentRegisterDto StudentRegisterDto){
        return "";
    }

    public String delete(Integer studentId) {
        var student = studentRepository.findById(studentId);
        if (student.isPresent()){
            studentRepository.deleteById(studentId);
        }
        else {
            return "No student found !";
        }
        return "Student deleted successfully";
    }

    public RegisterResponse<Object> login(LoginDto loginDto) {
        return RegisterResponse.builder()
                .created_at(Instant.now())
                .build();
    }

    public RegisterResponse<Object> register(StudentRegisterDto studentRegisterDto) {

        var classe = classesRepository.findById(studentRegisterDto.getClass_id());

        var student = Student.builder()
                .at(studentRegisterDto.getAt())
                .name(studentRegisterDto.getName())
                .sex(studentRegisterDto.getSex())
                .email(studentRegisterDto.getEmail())
                .address(studentRegisterDto.getAddress())
                .birthday(studentRegisterDto.getBirthday())
                .surname(studentRegisterDto.getSurname())
                .password(studentRegisterDto.getPassword())
                .student_code(studentRegisterDto.getStudent_code())
                .classe(classe.get())
                .build();

       // EnrollDto enrollDto = new EnrollDto();
        var enroll = Enroll.builder()
                .student(student)
                .year(studentRegisterDto.getYear())
                .section_id(studentRegisterDto.getSection_id())
                .class_id(studentRegisterDto.getClass_id())
                .build();

        var student_are_in_bd = studentRepository.findByEmail(studentRegisterDto.getEmail());

        if (student_are_in_bd.isPresent()){
            return RegisterResponse.builder()
                    .entity(null)
                    .message("student already exists !")
                    .created_at(Instant.now())
                    .build();
        }
        studentRepository.save(student);
        enrollRepository.save(enroll);
        return RegisterResponse.builder()
                .entity(student)
                .message("student successfully created !")
                .created_at(Instant.now())
                .build();
    }


}
