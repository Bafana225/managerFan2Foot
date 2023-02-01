package com.memel.manager.controler;

import com.memel.manager.model.Joueur;
import com.memel.manager.service.JoueurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

////////////
@CrossOrigin
////////////
@RestController
@RequestMapping("/joueur")
public class JoueurControler {
    private final JoueurService joueurService;
    // Constructeur
    public JoueurControler(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    // Méthodes
    @GetMapping("/all")
    public ResponseEntity<List<Joueur>>getAllJoueurs () {
        List<Joueur> joueurs = joueurService.findAllJoueurs();
        return new ResponseEntity<>(joueurs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable("id") Long id) {
        Joueur newJoueur = joueurService.findJoueurById(id);
        return new ResponseEntity<>(newJoueur, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Joueur> addJoueur(@RequestBody Joueur joueur) {
        Joueur newJoueur = joueurService.addJoueur(joueur);
        return new ResponseEntity<>(newJoueur, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Joueur> updateJoueur(@RequestBody Joueur joueur) {
        Joueur updateJoueur = joueurService.addJoueur(joueur);
        return new ResponseEntity<>(updateJoueur, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoueur(@PathVariable("id") Long id) {
        joueurService.deleteJoueur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
