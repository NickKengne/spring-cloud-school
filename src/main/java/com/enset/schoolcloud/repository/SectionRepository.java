package com.enset.schoolcloud.repository;

import com.enset.schoolcloud.entity.Classe;
import com.enset.schoolcloud.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, Integer> {
    Optional<Classe> findByClasse(Classe classe);

    List<Section> findAllByClasse(Classe classe);
}
