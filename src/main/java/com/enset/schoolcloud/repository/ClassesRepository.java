package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Classe;
import com.enset.schoolcloud.entity.ExamType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepository extends JpaRepository<Classe,Integer>{
}
