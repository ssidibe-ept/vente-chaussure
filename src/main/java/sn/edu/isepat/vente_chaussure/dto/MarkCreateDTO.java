package sn.edu.isepat.vente_chaussure.dto;

import lombok.Getter;
import lombok.Setter;
import sn.edu.isepat.vente_chaussure.entities.Mark;

@Getter
@Setter
public class MarkCreateDTO {
    private String  nom;

    private String description;

    public Mark ajoutMarque() {
        return Mark.builder()
                .nom(nom)
                .description(description)
                .build();
    }
}
