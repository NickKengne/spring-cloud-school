package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Optional<Teacher> findByEmail(String email);
}
