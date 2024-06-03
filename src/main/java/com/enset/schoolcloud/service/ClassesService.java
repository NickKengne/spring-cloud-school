package com.enset.schoolcloud.service;
import com.enset.schoolcloud.dto.ClasseDto;
import com.enset.schoolcloud.entity.Classe;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassesService {


    private final ClassesRepository classesRepository;
    private final TeacherRepository teacherRepository;

    public HttpStatus create(ClasseDto classeDto) {
        var teacherExist = teacherRepository.findById(classeDto.getTeacher_id()).orElseThrow(() -> new RuntimeException("No teacher found"));
            Classe classe = Classe.builder()
                    .cycle(classeDto.getCycle())
                    .name(classeDto.getName())
                    .name_numeric(classeDto.getName_numeric())
                    .teacher(teacherExist)
                    .build();
            classesRepository.save(classe);
            return HttpStatus.CREATED;
    }



}
