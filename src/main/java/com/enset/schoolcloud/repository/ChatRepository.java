package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChatRepository extends JpaRepository<Chat ,Integer> {
}
