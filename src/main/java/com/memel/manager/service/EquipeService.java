package com.memel.manager.service;

import com.memel.manager.exception.EquipeNotFoundException;
import com.memel.manager.model.Equipe;
import com.memel.manager.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;

    @Autowired
    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public List<Equipe> findAllEquipes(){
        return equipeRepository.findAll();
    }

    public Equipe updateEquipe(Equipe equipe){
        return equipeRepository.save(equipe);
    }

    public Equipe findEquipeById(Long id){
        return equipeRepository.findEquipeById(id)
                .orElseThrow(() -> new EquipeNotFoundException("L'équipe " + id + " n'a pas été trouvé dans la base de données."));
    }

    @Transactional
    public void deleteEquipe(Long id) {
        equipeRepository.deleteEquipeById(id);
    }


}


