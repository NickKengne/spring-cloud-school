package com.enset.schoolcloud.service;

import com.enset.schoolcloud.entity.Marks;
import com.enset.schoolcloud.repository.*;
import com.enset.schoolcloud.response.MarkDto;
import com.enset.schoolcloud.response.MarkResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkService {

    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;
    private final SectionRepository sectionRepository;
    private final SubjectRepository subjectRepository;
    private final ExamRepository examRepository;

    public MarkResponse insertMark(List<MarkDto> markDto) {
        for (MarkDto marks : markDto){
            var student = studentRepository.findById(marks.getStudent_id()).orElseThrow(() -> new RuntimeException("No student found"));
            var classe = classesRepository.findById(marks.getClass_id()).orElseThrow(() -> new RuntimeException("No class found"));
            var section =sectionRepository.findById(marks.getSection_id()).orElseThrow(() -> new RuntimeException("No section found"));
            var subject = subjectRepository.findById(marks.getSubject_id()).orElseThrow(() -> new RuntimeException("No subject found"));
            var exam = examRepository.findById(marks.getExam_id()).orElseThrow(() -> new RuntimeException("No Exam found"));


            var currentMarks = Marks.builder()
                    .mark_obtained(marks.getMark_obtained())
                    .exam(marks.getExam())
                    .comment(marks.getComment())
                    .examen(exam)
                    .test2(marks.getTest2())
                    .year(marks.getYear())
                    .student(student)
                    .subject(subject)
                    .section(section)
                    .classe(classe)
                    .build();
            markRepository.save(currentMarks);
        }

        return MarkResponse.builder()
                .error(false)
                .status_code(HttpStatus.CREATED)
                .message("Mark created successfully")
                .success(true)
                .build();

    }
}
