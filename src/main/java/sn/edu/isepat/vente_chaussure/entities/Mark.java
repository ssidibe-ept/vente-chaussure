package sn.edu.isepat.vente_chaussure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter   // Il va creer pour chaque article getters setters
@Entity  // Pour ajouter une table a la base de donnee
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremente l'ID
    private Integer id;

    @Column (nullable = false, unique = true, length = 50)
    private String nom;

    private String description;
}
