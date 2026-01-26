package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class lic1Test {

    /**
     * Contract:
     * lic1 should return false when the number of points is < 3, as the condition cannot be met.
     *
     * Expected Behavior:
     * The function shall return false when the number of points supplied is 2.
    */
    @Test
    void returnsFalseWhenFewerThanThreePoints() {
        lic1 lic1 = new lic1();
        Point[] points = {new Point(0, 1),
                        new Point(0, 2)
        };
        Parameters params = new Parameters();
        params.RADIUS1 = 1;
        assertFalse(lic1.evaluate(points, params));
    }

    /**
     * Contract:
     * lic1 should return true if there is a set of 3 consecutive points, which cannot be contained in
     * or on a circle of RADIUS1.
     * 
     * Expected behavior
     * Given 5 points (-3,6),(-4,-3),(-1,2),(8,-6), (7,4), and a RADIUS1 of 5, points 2-4 forming an acute triangle
     *  cannot be contained within or on the circle, and the function shall return true. 
     */
    @Test
    void returnsTrueWhenPointsForAcuteTriangleWhichCannotBeContained(){
        lic1 lic1 = new lic1();
        Point[] points = {new Point(-3, 6),
                        new Point(-4, -3),
                        new Point(-1, 2),
                        new Point(8, -6),
                        new Point(7, 4),
        };
        Parameters params = new Parameters();
        params.RADIUS1 = 5;
        assertTrue(lic1.evaluate(points, params));
    }


    /**
     * Contract:
     * lic1 should return true if there is a set of 3 consecutive points, which cannot be contained in
     * or on a circle of RADIUS1.
     * 
     * Expected behavior
     * Given 5 points (1.5,1),(-1,-2),(1,3),(-3,-3),(7,4) and a RADIUS1 of 3, points 2-4 forming an obtuse triangle
     *  cannot be contained within or on the circle, and the function shall return true. 
     */
    @Test
    void returnsTrueWhenPointsForObtuseTriangleWhichCannotBeContained(){
        lic1 lic1 = new lic1();
        Point[] points = {new Point(1.5, 1),
                        new Point(-1, -2),
                        new Point(1, 3),
                        new Point(-3, -3),
                        new Point(7, 4),
        };
        Parameters params = new Parameters();
        params.RADIUS1 = 3;
        assertTrue(lic1.evaluate(points, params));
    }

     /**
     * Contract:
     * lic1 should return false if there is not a set of 3 consecutive points, which cannot be contained in
     * or on a circle of RADIUS1.
     * 
     * Expected behavior
     * Given 5 points (0,0),(0,1),(1,0),(1,1),(0.5,0.5) and a RADIUS1 of sqrt(2)/2, all points can be contained
     * within or on the circle, so the function shall return false
     */
    @Test
    void returnFalseWhenAllPointsCanBeContained(){
        lic1 lic1 = new lic1();
        Point[] points = {new Point(0, 0),
                        new Point(0, 1),
                        new Point(1, 0),
                        new Point(1, 1),
                        new Point(0.5, 0.5),
        };
        Parameters params = new Parameters();
        params.RADIUS1 = Math.sqrt(2)/2;
        assertFalse(lic1.evaluate(points, params));
    }
     /**
     * Contract:
     * lic1 should return false if there is not a set of 3 consecutive points, which cannot be contained in
     * or on a circle of RADIUS1.
     * 
     * Expected behavior
     * Given 5 points (0.5,0.5),(0,0),(0.7,0),(2,0)and a RADIUS1 of 0.5, the last 3 points located on one line cannot be contained,
     * and the function shall return true.
     */
    @Test
    void returnsTrueWhenCollinearPointsCannotBeContained() {
        lic1 lic1 = new lic1();
        Point[] points = {new Point(0.5, 0.5),
                        new Point(0, 0),
                        new Point(0.7, 0),
                        new Point(2, 0),
        };
        Parameters params = new Parameters();
        params.RADIUS1 = 0.5;
        assertTrue(lic1.evaluate(points, params));
    }
}

