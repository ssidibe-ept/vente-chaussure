package sn.edu.isepat.vente_chaussure.init;

import org.springframework.boot.CommandLineRunner;
import sn.edu.isepat.vente_chaussure.entities.Mark;

public class initMark implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("###Initialisation des marks");
        Mark nike = new Mark();
        nike.setNom("Nike");
        markRepository.save();
    }

}
