package com.enset.schoolcloud.controller;

import com.enset.schoolcloud.dto.SectionDto;
import com.enset.schoolcloud.entity.Section;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.SectionRepository;
import com.enset.schoolcloud.repository.TeacherRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/section", produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController {
    private final SectionRepository sectionRepository;
    private final TeacherRepository teacherRepository;
    private final ClassesRepository classesRepository;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody SectionDto sectionDto){
        var teacher = teacherRepository.findById(sectionDto.getTeacher_id()).orElseThrow(() -> new RuntimeException("No teacher Found !"));
        var classe = classesRepository.findById(sectionDto.getClass_id()).orElseThrow(() -> new RuntimeException("No class found"));
        var section = Section.builder()
                .name(sectionDto.getName())
                .teacher(teacher)
                .classe(classe)
                .build();
        sectionRepository.save(section);
        return ResponseEntity.ok("Section created successfully");
    }
}

