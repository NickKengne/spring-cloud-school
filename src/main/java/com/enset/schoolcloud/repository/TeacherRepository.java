package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
