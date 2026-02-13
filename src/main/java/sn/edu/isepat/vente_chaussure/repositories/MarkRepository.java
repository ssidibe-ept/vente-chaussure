package sn.edu.isepat.vente_chaussure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepat.vente_chaussure.entities.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
}