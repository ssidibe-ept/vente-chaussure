package sn.edu.isepat.vente_chaussure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincremente la ligne
    private Integer id;

    @Column(nullable = false,unique = true,length = 50)
    private String nom;

    private String description;
}
