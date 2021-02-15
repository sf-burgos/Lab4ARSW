package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.impl.SubSamplingFilters;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Brayan Burgos
 * @author Daniel Varón
 */
public class SubSamplingFiltersTest {
    @Test
    public void filters() {
        SubSamplingFilters rf= new SubSamplingFilters();

        List<Point> points = new ArrayList<Point>();
        List<Point> pointsExpected = new ArrayList<Point>();

        Point p1=new Point(1,1);
        points.add(p1);
        pointsExpected.add(p1);

        points.add(new Point(1,1));

        Point p2=new Point(1,1);
        points.add(p2);
        pointsExpected.add(p2);

        points.add(new Point(1,1));

        Point p3=new Point(9,10);
        points.add(p3);
        pointsExpected.add(p3);

        points.add(new Point(7,5));

        Point p4=new Point(10,9);
        points.add(p4);
        pointsExpected.add(p4);



        Blueprint pn=rf.Filters(new Blueprint("Pepito","Plano",points));
        assertEquals(pointsExpected,pn.getPoints());
    }
}
