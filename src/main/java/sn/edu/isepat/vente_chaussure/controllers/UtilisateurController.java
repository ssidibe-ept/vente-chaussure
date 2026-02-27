package sn.edu.isepat.vente_chaussure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepat.vente_chaussure.dto.UtilisateurCreateDTO;
import sn.edu.isepat.vente_chaussure.entities.Utilisateur;
import sn.edu.isepat.vente_chaussure.repositories.UtilisateurRepository;
import sn.edu.isepat.vente_chaussure.services.UtilisateurService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<Utilisateur> getAllUser(){
        return utilisateurService.findAllUser();
    }

    @GetMapping("/{id}")
    public Utilisateur findById(@PathVariable Integer id) {
        return utilisateurService.findById(id);
    }

    @Operation(summary = "Enregistrer un utilisateur", description = "Permet d'enrgistrer un utilisateur, l'id ne doit pas etre renseigne")
    @PostMapping
    public ResponseEntity<?>  ajout(@RequestBody UtilisateurCreateDTO user) {
        return utilisateurService.ajout(user.toUtilisateur());
    }

    @PutMapping("/{id}")
    public Utilisateur modifier(@RequestBody UtilisateurCreateDTO user, @PathVariable Integer id) {
        return utilisateurService.modifier(id, user);
    }

    @DeleteMapping("/{id}")
    public void supprime(@PathVariable Integer id) {
        utilisateurService.supprime(id);
    }
}
