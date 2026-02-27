package sn.edu.isepat.vente_chaussure.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepat.vente_chaussure.dto.MarkCreateDTO;
import sn.edu.isepat.vente_chaussure.entities.Mark;
import sn.edu.isepat.vente_chaussure.repositories.MarkRepository;
import sn.edu.isepat.vente_chaussure.services.MarkService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/marques")
public class MarkController {

    private final MarkService markService;
    private final MarkRepository markRepository;

    @GetMapping
    public List<Mark> getAllMark() {
        return markService.findAllMark();
    }

    @GetMapping("/{id}")
    public Mark findThisMark(@PathVariable Integer id) {
        return markService.findMark(id);
    }

    @PostMapping
    public Mark ajout(@RequestBody MarkCreateDTO mark){
        return markService.ajout(mark.ajoutMarque());
    }
}
