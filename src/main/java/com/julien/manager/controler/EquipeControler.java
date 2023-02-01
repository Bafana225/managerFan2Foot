package com.julien.manager.controler;


import com.julien.manager.model.Equipe;
import com.julien.manager.service.EquipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

////////////
@CrossOrigin
////////////
@RestController
@RequestMapping("/equipe")
public class EquipeControler {
    private final EquipeService equipeService;

    // Constructeur
    public EquipeControler(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    // Méthodes
    @GetMapping("/all")
    public ResponseEntity<List<Equipe>> getAllEquipes() {
        List<Equipe> equipes = equipeService.findAllEquipes();
        return new ResponseEntity<>(equipes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Equipe> getEquipêById(@PathVariable("id_equipe") Long id) {
        Equipe newEquipe = equipeService.findEquipeById(id);
        return new ResponseEntity<>(newEquipe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Equipe> addJoueur(@RequestBody Equipe equipe) {
        Equipe newEquipe = equipeService.addEquipe(equipe);
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Equipe> updateJoueur(@RequestBody Equipe equipe) {
        Equipe updateEquipe = equipeService.addEquipe(equipe);
        return new ResponseEntity<>(updateEquipe, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoueur(@PathVariable("id") Long id) {
        equipeService.deleteEquipe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
