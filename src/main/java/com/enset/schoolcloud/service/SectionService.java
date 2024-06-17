package com.enset.schoolcloud.service;

import com.enset.schoolcloud.dto.SectionDto;
import com.enset.schoolcloud.entity.Section;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.SectionRepository;
import com.enset.schoolcloud.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionService {

    private final TeacherRepository teacherRepository;
    private final ClassesRepository classesRepository;
    private final SectionRepository sectionRepository;

    public String create(SectionDto sectionDto) {
        var teacher = teacherRepository.findById(sectionDto.getTeacher_id()).orElseThrow(() -> new RuntimeException("No teacher Found !"));
        var classe = classesRepository.findById(sectionDto.getClass_id()).orElseThrow(() -> new RuntimeException("No class found"));
        var section = Section.builder()
                .name(sectionDto.getName())
                .teacher(teacher)
                .classe(classe)
                .build();
        sectionRepository.save(section);
        return "Section created successfully !";
    }
}
