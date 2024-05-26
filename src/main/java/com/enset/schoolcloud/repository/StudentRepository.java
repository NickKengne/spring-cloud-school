package com.enset.schoolcloud.repository;


import com.enset.schoolcloud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
