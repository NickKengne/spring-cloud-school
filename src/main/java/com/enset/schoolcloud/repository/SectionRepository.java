package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Classe;
import com.enset.schoolcloud.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {

    Section findByClasse(Classe classe);
}
