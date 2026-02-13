package sn.edu.isepat.vente_chaussure.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.edu.isepat.vente_chaussure.entites.Mark;

@Component
public class initMark implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception{
        System.out.println("### Initialisation des amrques");

        Mark nike = new Mark();
        nike.setNom("Nike");
        

    }




}
