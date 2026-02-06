package sn.edu.isepat.vente_chaussure.entities;

import jakarta.persistence.*;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_incrementation de l'id
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String nom;
    private String description;
}
