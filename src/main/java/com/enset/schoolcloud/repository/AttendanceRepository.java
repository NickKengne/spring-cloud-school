package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {
}
