package com.enset.schoolcloud.service;


import com.enset.schoolcloud.controller.ExamTypeController;
import com.enset.schoolcloud.entity.ExamType;
import com.enset.schoolcloud.repository.ExamTypeRepository;
import com.enset.schoolcloud.response.ExamResponseCreate;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExamTypeService {

    private final ExamTypeRepository examTypeRepository;

    public ExamResponseCreate create(Map<String,String> examName) {

        //extract name of examtype since the object examname
        String name = examName.get("name");

        if (name.isEmpty()){
            return ExamResponseCreate.builder()
                    .message("the name is blank or empty")
                    .status(HttpStatus.BAD_REQUEST)
                    .created_at(Instant.now())
                    .build();
        }
        else {
            //charge exam
            var exam = ExamType.builder()
                    .exam_name(name)
                    .build();
            //save exam
            examTypeRepository.save(exam);
            return ExamResponseCreate.builder()
                    .created_at(Instant.now())
                    .message("Exam created succesfully")
                    .status(HttpStatus.CREATED)
                    .build();
        }
    }
}
