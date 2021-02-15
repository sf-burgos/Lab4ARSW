package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.impl.RedundancyFilters;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan Burgos
 * @author Daniel Varón
 */

public class RedundancyFiltersTest {

    @Test
    public void filters() {
        RedundancyFilters rf= new RedundancyFilters();

        List<Point> points = new ArrayList<Point>();
        List<Point> pointsExpected = new ArrayList<Point>();
        Point p1=new Point(1,1);
        points.add(p1);
        pointsExpected.add(p1);
        Point p2=new Point(7,5);
        points.add(p2);
        pointsExpected.add(p2);
        points.add(new Point(1,1));
        Point p3=new Point(9,10);
        points.add(p3);
        pointsExpected.add(p3);
        Point p4=new Point(10,9);
        points.add(p4);
        pointsExpected.add(p4);
        points.add(new Point(1,1));
        points.add(new Point(7,5));
        Blueprint pn=rf.Filters(new Blueprint("Pepito","Plano",points));
        assertEquals(pointsExpected,pn.getPoints());
    }
}
