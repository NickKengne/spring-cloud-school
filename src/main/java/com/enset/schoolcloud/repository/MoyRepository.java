package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Moy_Annuelle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoyRepository extends JpaRepository<Moy_Annuelle,Integer> {
}
