package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.dto.ExamDto;
import com.enset.schoolcloud.entity.Exam;
import com.enset.schoolcloud.entity.ExamType;
import com.enset.schoolcloud.repository.ExamRepository;
import com.enset.schoolcloud.repository.ExamTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/exam", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamController {

    private final ExamRepository examRepository;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExamDto examDto){
        var exam = Exam.builder()
                .date(examDto.getDate())
                .year(examDto.getYear())
                .name(examDto.getName())
                .comment(examDto.getComment())
                .build();

        examRepository.save(exam);
        return ResponseEntity.ok("Exam created !");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Exam>> getExam (){
        return ResponseEntity.ok(examRepository.findAll());
    }

}
