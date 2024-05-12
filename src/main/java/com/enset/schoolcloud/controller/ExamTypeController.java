package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.entity.ExamType;
import com.enset.schoolcloud.repository.ExamTypeRepository;
import com.enset.schoolcloud.response.ExamResponseCreate;
import com.enset.schoolcloud.service.ExamTypeService;
import lombok.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/examtype", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class ExamTypeController {

    private final ExamTypeService examTypeService;
    private final ExamTypeRepository examTypeRepository;


    @PostMapping(path = "/create")
    public ExamResponseCreate create (@RequestBody Map<String ,String> exam_name){
        return examTypeService.create(exam_name);
    }

    @GetMapping("/{id}")
    public Optional<ExamType> getById (@PathVariable Integer id){
        return examTypeRepository.findById(id);
    }

}
