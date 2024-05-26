package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
