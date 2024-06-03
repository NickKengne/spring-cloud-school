package com.enset.schoolcloud.controller;
import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.RegisterDto;
import com.enset.schoolcloud.dto.TeacherRegisterDto;

import com.enset.schoolcloud.entity.Subject;
import com.enset.schoolcloud.entity.Teacher;
import com.enset.schoolcloud.repository.SubjectRepository;
import com.enset.schoolcloud.repository.TeacherRepository;
import com.enset.schoolcloud.response.RegisterResponse;
import com.enset.schoolcloud.service.SubjectService;
import com.enset.schoolcloud.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/teacher", produces = MediaType.APPLICATION_JSON_VALUE)

public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final SubjectService subjectService;

    @PostMapping("/auth/register")
    public RegisterResponse<Object> register(@RequestBody TeacherRegisterDto teacherRegisterDto) {
        return teacherService.register(teacherRegisterDto);
    }

    //implementer le login
    @PostMapping("/auth/login")
    public RegisterResponse<Object>  login(@RequestBody LoginDto loginDto){
        return teacherService.login(loginDto);
    }

    @DeleteMapping("/delete/{teacher_id}")
    public ResponseEntity<String> delete (@PathVariable("teacher_id") Integer teacher_id){
        return ResponseEntity.ok(teacherService.delete(teacher_id));
    }

    @PutMapping("/update/{teacher_id}")
    public ResponseEntity<String> update (@RequestBody RegisterDto registerDto , @PathVariable("teacher_id") Integer teacher_id){
        return ResponseEntity.ok(teacherService.update(teacher_id, registerDto));
    }

    @GetMapping("/all")
    public List<Teacher> getAll (){
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Teacher>> getById (@PathVariable("id") Integer id){
        return ResponseEntity.ok(teacherRepository.findById(id));
    }
}