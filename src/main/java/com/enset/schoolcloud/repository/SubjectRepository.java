package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Classe;
import com.enset.schoolcloud.entity.Section;
import com.enset.schoolcloud.entity.Subject;
import com.enset.schoolcloud.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    List<Subject> findAllByClasse(Classe classe);

    List<Subject> findAllByTeacher(Teacher teacher);
}
