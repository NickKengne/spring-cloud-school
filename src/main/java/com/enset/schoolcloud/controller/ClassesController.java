package com.enset.schoolcloud.controller;

import com.enset.schoolcloud.dto.ClasseDto;
import com.enset.schoolcloud.dto.SectionDto;
import com.enset.schoolcloud.entity.Classe;
import com.enset.schoolcloud.repository.ClassesRepository;
import com.enset.schoolcloud.repository.TeacherRepository;
import com.enset.schoolcloud.service.ClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/classes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClassesController {

private final ClassesRepository classesRepository;
private final ClassesService classesService;
    private final TeacherRepository teacherRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HttpStatus> createClasse (@RequestBody ClasseDto classeDto){
        return ResponseEntity.ok(classesService.create(classeDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Classe>> getAllClasses (){
        return ResponseEntity.ok(classesRepository.findAll());
    }

    @GetMapping("/{class_id}")
    public ResponseEntity<Optional<Classe>> getClassById (@PathVariable("class_id") Integer class_id){
        return ResponseEntity.ok(classesRepository.findById(class_id));
    }

    @PutMapping("/update/{class_id}")
    public ResponseEntity<HttpStatus> updateClasseById (@PathVariable("class_id") Integer class_id , @RequestBody ClasseDto classeDto){
        var thisClasse = classesRepository.findById(class_id);
        var thisTeacher = teacherRepository.findById(classeDto.getTeacher_id());

        if (thisClasse.isPresent() && thisTeacher.isPresent()){
            thisClasse.get().setName(classeDto.getName());
            thisClasse.get().setName_numeric(classeDto.getName_numeric());
            thisClasse.get().setCycle(classeDto.getCycle());
            thisClasse.get().setTeacher(thisTeacher.get());
            classesRepository.save(thisClasse.get());
            return ResponseEntity.ok(HttpStatus.CONTINUE);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{class_id}")
    public ResponseEntity<Map<String,String>> deleteClass (@PathVariable("class_id") Integer class_id){
        var thisClasse = classesRepository.findById(class_id);
        if (thisClasse.isEmpty()){
            Map<String, String> response = Map.of("message","Unknown classe");
            return ResponseEntity.ok(response);
        }
        classesRepository.deleteById(class_id);
        Map<String, String> response = Map.of("message","delete successfully");
        return ResponseEntity.ok(response);
    }

}
