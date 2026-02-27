package sn.edu.isepat.vente_chaussure.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.edu.isepat.vente_chaussure.dto.ErrorMessage;
import sn.edu.isepat.vente_chaussure.dto.UtilisateurCreateDTO;
import sn.edu.isepat.vente_chaussure.entities.Utilisateur;
import sn.edu.isepat.vente_chaussure.repositories.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public ResponseEntity<?> ajout(Utilisateur user) {
        if (user.getId() != null) {
            // throw new RuntimeException("l'id ne doit pas etre renseigne pour un nouvel utilisateur");
            return ResponseEntity.status(450).build();
        }

        if (user.getPrenom() == null || user.getPrenom().isBlank()){
            // throw new RuntimeException("Le prenom est obligatoire");
            return ResponseEntity.status(451).body(new ErrorMessage(451, "Le prenom est obligatoire"));
        }

        if (user.getNom() == null || user.getNom().isBlank()){
            // throw new RuntimeException("Le nom est obligatoire");
            return ResponseEntity.status(452).build();
        }

        if (
                (user.getTelephone() == null || user.getTelephone().isBlank())
                && (user.getEmail() == null || user.getEmail().isBlank())
        ){
           // throw new RuntimeException("Vous devez renseigné l'email ou le telephone");
            return ResponseEntity.status(453).build();
        }


        Utilisateur result =  utilisateurRepository.save(user);
        return ResponseEntity.status(201).body(result);
    }

    public List<Utilisateur> findAllUser() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur findById(Integer id) {
        Optional<Utilisateur> utilisateurdb = utilisateurRepository.findById(id);
        if (utilisateurdb.isPresent()) {
            Utilisateur user = utilisateurdb.get();
            return user;
        }
        throw new RuntimeException("L'utilisateur dont l'id est " + id + " n'existe pas");
    }


    public Utilisateur modifier(Integer id, UtilisateurCreateDTO userDTO) {
        Optional<Utilisateur> userdb = utilisateurRepository.findById(id);
        if (userdb.isPresent()) {
            Utilisateur user = userdb.get();
            user.setPrenom(userDTO.getPrenom());
            user.setNom(userDTO.getNom());
            user.setAdresse(userDTO.getAdresse());
            user.setTelephone(userDTO.getTelephone());
            user.setEmail(userDTO.getEmail());

            utilisateurRepository.save(user);

            return user;
        } else {
            throw new RuntimeException("L'utilisateur dont l'id est " + id + " n'existe pas");
        }
    }

    public void supprime(Integer id) {
        Optional<Utilisateur> userdb = utilisateurRepository.findById((id));

        if (userdb.isPresent()) {
            // utilisateurRepository.deleteById(id);
            Utilisateur user = userdb.get();
            utilisateurRepository.delete(user);
        } else {
            throw new RuntimeException("L'utilisateur dont l'id est " + id + " n'existe pas");
        }
    }
}
