package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarkRepository extends JpaRepository<Marks,Integer> {
}
