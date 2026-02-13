package sn.edu.isepat.vente_chaussure.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.edu.isepat.vente_chaussure.entities.Chaussure;
import sn.edu.isepat.vente_chaussure.repositories.ChaussureRepository;

@Order(2)
@Component
public class InitChaussure implements CommandLineRunner {
    private final ChaussureRepository chaussureRepository;
    public InitChaussure(ChaussureRepository chaussureRepository) {
        this.chaussureRepository = chaussureRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("initialisation chaussure");
        Chaussure timberland = new Chaussure();
        timberland.setNom("Timberland");
        timberland.setPrix(60000.0);
        chaussureRepository.save(timberland);

        Chaussure timberland2 = new Chaussure();
        timberland2.setNom("Timberland2");
        timberland2.setPrix(60000.0);
        chaussureRepository.save(timberland2);

    }
}
