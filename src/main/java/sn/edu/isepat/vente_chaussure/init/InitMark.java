package sn.edu.isepat.vente_chaussure.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.isepat.vente_chaussure.entities.Mark;

@Component
public class InitMark implements CommandLineRunner {

    private final sn.edu.isepat.vente_chaussure.repository.MarkRepository markRepository;

    public InitMark(sn.edu.isepat.vente_chaussure.repository.MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("### initialisation des marks");
        Mark nike=new Mark();
        nike.setNom("Nike");
    }
}