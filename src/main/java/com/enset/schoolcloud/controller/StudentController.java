package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.RegisterDto;
import com.enset.schoolcloud.entity.Admin;
import com.enset.schoolcloud.entity.Student;
import com.enset.schoolcloud.repository.StudentRepository;
import com.enset.schoolcloud.response.RegisterResponse;
import com.enset.schoolcloud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/student",produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;


    /*
    @PostMapping("/auth/register")
    public RegisterResponse<Object> register (@RequestBody RegisterDto registerDto){
        return studentService.register(registerDto);
    }

    //implementer le login
    @PostMapping("/auth/login")
    public RegisterResponse<Object>  login(@RequestBody LoginDto loginDto){
        return studentService.login(loginDto);
    }

    @PostMapping("/delete/{student_id}")
    public ResponseEntity<String> delete (@PathVariable("student_id") Integer student_id){
        return ResponseEntity.ok(studentService.delete(student_id));
    }

    @PutMapping("/update/{student_id}")
    public ResponseEntity<String> update (@RequestBody RegisterDto registerDto , @PathVariable("student_id") Integer student_id){
        return ResponseEntity.ok(studentService.update(student_id, registerDto));
    }

    @GetMapping("/all")
    public List<Student> getAll (){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getById (@PathVariable("id") Integer id){
        return ResponseEntity.ok(studentRepository.findById(id));
    }

     */

}
