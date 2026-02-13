package sn.edu.isepat.vente_chaussure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepat.vente_chaussure.entities.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
}