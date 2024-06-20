package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.dto.SubjectDto;
import com.enset.schoolcloud.entity.Subject;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.SubjectRepository;
import com.enset.schoolcloud.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/subject", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectRepository subjectRepository;
    private final ClassesRepository classesRepository;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HttpStatus> create (@RequestBody SubjectDto subjectDto){
        return ResponseEntity.ok(subjectService.create(subjectDto));
    }

    @DeleteMapping("/delete/{subject_id}")
    public ResponseEntity<Map<String,String>> deleteSubject(@PathVariable("subject_id") Integer subject_id){
        var thisSubject = subjectRepository.findById(subject_id);
        if (thisSubject.isEmpty()){
            Map<String, String> response = Map.of("message","Unknown subject");
            return ResponseEntity.ok(response);
        }
        subjectRepository.deleteById(subject_id);
        Map<String, String> response = Map.of("message","delete successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subject>> getAll (){
        return ResponseEntity.ok(subjectRepository.findAll());
    }

    @GetMapping("/{subject_id}")
    public ResponseEntity<List<Subject>> getById (@PathVariable("subject_id") Integer subject_id){
        return ResponseEntity.ok(subjectRepository.findAll());
    }

    @GetMapping("/classe/{class_id}")
    public ResponseEntity<List<Subject>> getAllByClassId (@PathVariable("class_id") Integer class_id){
        var classe = classesRepository.findById(class_id).orElseThrow(() -> new RuntimeException("No class found"));
        return ResponseEntity.ok(subjectRepository.findAllByClasse(classe));
    }

    @GetMapping("/teacher/{teacher_id}")
    public ResponseEntity<List<Subject>> getSubjectByTeacherByClass (@PathVariable("teacher_id") Integer teacher_id){
        return ResponseEntity.ok(subjectService.getSubjecByTeacherByClass(teacher_id));
    }
}
