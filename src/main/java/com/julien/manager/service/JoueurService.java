package com.julien.manager.service;

import com.julien.manager.exception.JoueurNotFoundException;
import com.julien.manager.model.Joueur;
import com.julien.manager.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class JoueurService {
    private final JoueurRepository joueurRepository;

    @Autowired
    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    public Joueur addJoueur(Joueur joueur) {
        joueur.setNum_licence(UUID.randomUUID().toString());
        return joueurRepository.save(joueur);
    }

    public List<Joueur> findAllJoueurs(){
        return joueurRepository.findAll();
    }

    public Joueur updateJoueur(Joueur joueur){
        return joueurRepository.save(joueur);
    }

    public Joueur findJoueurById(Long id){
        return joueurRepository.findById(id)
                .orElseThrow(() -> new JoueurNotFoundException("Le joueur " + id + " n'a pas été trouvé dans la base de données."));
    }

    @Transactional
    public void deleteJoueur(Long id) {
        joueurRepository.deleteJoueurById(id);
    }

}