package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.StudentRegisterDto;
import com.enset.schoolcloud.entity.Student;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.ParentRepository;
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
    private final ClassesRepository classesRepository;
    private final ParentRepository parentRepository;


    @PostMapping("/auth/register")
    public RegisterResponse<Object> register (@RequestBody StudentRegisterDto studentRegisterDto){
        return studentService.register(studentRegisterDto);
    }

    //implementer le login
    @PostMapping("/auth/login")
    public RegisterResponse<Object>  login(@RequestBody LoginDto loginDto){
        return studentService.login(loginDto);
    }

    @DeleteMapping("/delete/{student_id}")
    public ResponseEntity<String> delete (@PathVariable("student_id") Integer student_id){
        return ResponseEntity.ok(studentService.delete(student_id));
    }

    @PutMapping("/update/{student_id}")
    public ResponseEntity<String> update (@RequestBody StudentRegisterDto studentRegisterDto , @PathVariable("student_id") Integer student_id){
        return ResponseEntity.ok(studentService.update(student_id, studentRegisterDto ));
    }

    @GetMapping("/all")
    public List<Student> getAll (){
        return studentRepository.findAll();
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> countStudent (){
        return ResponseEntity.ok(studentRepository.findAll().size());
    }

    @GetMapping("/parent/count")
    public ResponseEntity<Integer> countParent (){
        return ResponseEntity.ok(parentRepository.findAll().size());
    }


    @GetMapping("/{student_id}")
    public ResponseEntity<Optional<Student>> getById (@PathVariable("student_id") Integer id){
        return ResponseEntity.ok(studentRepository.findById(id));
    }

    @GetMapping("/classe/{class_id}")
    public ResponseEntity<List<Student>> getStudentByClasse (@PathVariable("class_id") Integer class_id){
        var classe = classesRepository.findById(class_id).orElseThrow(() -> new RuntimeException("No class Found"));
        return ResponseEntity.ok(studentRepository.findAllByClasse(classe));
    }

    @GetMapping("/student/sex")
    public ResponseEntity<Integer> studentBySex (){
        String sex = String.valueOf('F');
        return ResponseEntity.ok(studentRepository.findBySex(sex).size());
    }







}
