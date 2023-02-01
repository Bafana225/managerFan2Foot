package com.memel.manager.repository;

import com.memel.manager.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    void deleteEquipeById(Long id);

    Optional<Equipe> findEquipeById(Long id);

}
