package com.enset.schoolcloud.repository;


import com.enset.schoolcloud.entity.Classe;
import com.enset.schoolcloud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByClasse(Classe classe);
}
