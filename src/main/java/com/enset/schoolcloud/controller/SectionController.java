package com.enset.schoolcloud.controller;

import com.enset.schoolcloud.dto.SectionDto;
import com.enset.schoolcloud.entity.Classe;
import com.enset.schoolcloud.entity.Section;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.SectionRepository;
import com.enset.schoolcloud.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/section", produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController {
    private final SectionRepository sectionRepository;
    private final ClassesRepository classesRepository;
    private final SectionService sectionService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SectionDto sectionDto){
        return ResponseEntity.ok(sectionService.create(sectionDto));
    }

    @GetMapping("/{class_id}")
    public ResponseEntity<List<Section>> getSectionByClasse (@PathVariable("class_id") Integer class_id){
        var classe = classesRepository.findById(class_id).orElseThrow(() -> new RuntimeException("No class found"));
        return ResponseEntity.ok(sectionRepository.findAllByClasse(classe));
    }
}

