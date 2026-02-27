package sn.edu.isepat.vente_chaussure.services;

import org.springframework.stereotype.Service;
import sn.edu.isepat.vente_chaussure.entities.Mark;
import sn.edu.isepat.vente_chaussure.repositories.MarkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {
    private final MarkRepository markRepository;

    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public List<Mark> findAllMark() {
        return markRepository.findAll();
    }

    public Mark findMark(Integer id) {
        Optional<Mark> markdb = markRepository.findById(id);

        if (markdb.isPresent()) {
            Mark marque = markdb.get();
            return marque;
        }

        throw new RuntimeException("La marque avec l'id " + id + " n'existe pas");
    }

    public Mark ajout(Mark marque) {
        if (marque.getNom() == null || marque.getNom().isBlank()){
            throw new RuntimeException("Le nom est obligatoire");
        }

        return markRepository.save(marque);
    }
}
