package sn.edu.isepat.vente_chaussure.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.edu.isepat.vente_chaussure.entities.Mark;
import sn.edu.isepat.vente_chaussure.repositories.MarkRepository;

@Order(1)
@Component
public class InitMark implements CommandLineRunner {

    private final MarkRepository markRepository;

    public InitMark(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("### initialisation des marks");
        Mark nike=new Mark();
        nike.setNom("Nike");
      markRepository.save(nike);

      Mark hermes=new Mark();
        hermes.setNom("hermes rose");
        markRepository.save(hermes);

    }
}
