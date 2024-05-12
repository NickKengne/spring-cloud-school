package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.ExamType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExamTypeRepository extends JpaRepository<ExamType , Integer> {
    Optional<ExamType> findById(Integer id);
}
