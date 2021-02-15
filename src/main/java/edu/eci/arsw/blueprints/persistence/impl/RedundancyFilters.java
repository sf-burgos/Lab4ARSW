package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.FiltersPersistence;

import java.util.ArrayList;
import java.util.List;

public class RedundancyFilters implements FiltersPersistence {

    @Override
    public Blueprint Filters(Blueprint bpp) {
        List<Point> lista =bpp.getPoints();
        List<Point> salida = new ArrayList<>();

        for (int i=0;i<lista.size()-1;i++) {
            if (lista.get(i)!=null){
               salida.add(lista.get(i));
            }
            for (int j=i+1 ;j<lista.size();j++) {
                if (i!=j) {
                    if (lista.get(i).getX() == lista.get(j).getX() && lista.get(i).getY() == lista.get(j).getY())
                        lista.set(j,null);
                }


            }
        }
        return new Blueprint(bpp.getAuthor(), bpp.getName(), salida);

    }
}
