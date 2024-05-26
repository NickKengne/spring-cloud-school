package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
