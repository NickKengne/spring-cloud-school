package com.enset.schoolcloud.service;


import com.enset.schoolcloud.dto.SubjectDto;
import com.enset.schoolcloud.entity.Subject;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.SectionRepository;
import com.enset.schoolcloud.repository.SubjectRepository;
import com.enset.schoolcloud.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final ClassesRepository classesRepository;
    private final TeacherRepository teacherRepository;
    private final SectionRepository sectionRepository;
    private final SubjectRepository subjectRepository;

    public HttpStatus create(SubjectDto subjectDto) {
        var classe = classesRepository.findById(subjectDto.getClass_id()).orElseThrow(() -> new RuntimeException("No classe found"));
        var teacher = teacherRepository.findById(subjectDto.getTeacher_id()).orElseThrow(() -> new RuntimeException("No teacher found"));
        var section = sectionRepository.findById(subjectDto.getSection_id()).orElseThrow(() -> new RuntimeException("NO section found"));

        var thisSubject = Subject.builder()
                .coef(subjectDto.getCoef())
                .code(subjectDto.getCode())
                .year(subjectDto.getYear())
                .name(subjectDto.getName())
                .teacher(teacher)
                .Section(section)
                .classe(classe)
                .build();
        return HttpStatus.CREATED;
    }

    public List<Subject> getSubjecByTeacherByClass(Integer teacher_id) {
        var teacher = teacherRepository.findById(teacher_id).orElseThrow(() -> new RuntimeException("No teacher found"));
        return subjectRepository.findAllByTeacher(teacher);
    }
}
