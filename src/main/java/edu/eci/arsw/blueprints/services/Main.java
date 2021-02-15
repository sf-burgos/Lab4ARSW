package edu.eci.arsw.blueprints.services;


import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class Main {
    public static void  main(String[] args )  {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bpp = ac.getBean(BlueprintsServices.class);
        try {
            Point[] pts0 = new Point[]{new Point(30, 30), new Point(5, 5)};
            Blueprint bp0 = new Blueprint("intento", "onepaint", pts0);
            Blueprint bp1 = new Blueprint("intento", "twopaint", pts0);
            bpp.addNewBlueprint(bp0);
            bpp.addNewBlueprint(bp1);
            Set<Blueprint> byAuthor = bpp.getBlueprintsByAuthor("intento");
            System.out.println("Por autores:");
            for(Blueprint e : byAuthor){
                System.out.println("Autor: "+e.getAuthor()+ " Plano: "+e.getName());
            }
            System.out.println("Por autor y nombre:");



            System.out.println(bpp.getBlueprint("intento", "onepaint").getName());
        }catch (BlueprintNotFoundException | BlueprintPersistenceException e) {
            e.printStackTrace();
        }


    }
}
