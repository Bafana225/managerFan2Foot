package com.memel.manager.repository;

import com.memel.manager.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {

    void deleteJoueurById(Long id);

    Optional<Joueur> findJoueurById(Long id);

}
