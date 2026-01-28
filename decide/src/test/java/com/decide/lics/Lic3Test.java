package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class Lic3Test {
    /**
     * Contract:
     * There exists at least one set of three consecutive data points that are the vertices of a triangle
     * with area greater than AREA1.
     * 
     * Expected Behavior:
     * When provided with three consecutive point that create a triangle with area greater than AREA1, the evaluation
     * method should return true.
     */
    @Test
    void GreaterAreaConsecutive(){
        Parameters p = new Parameters();
        p.setAREA1(1.0);

        Point[] points = {
            new Point(0.0, 0.0),
            new Point(2.0, 0.0),
            new Point(2.0, 2.0)
        };
        Lic3 Lic3 = new Lic3();
        assertTrue(Lic3.evaluate(points, p));
    }
        /**
     * Contract:
     * There exists at least one set of three consecutive data points that are the vertices of a triangle
     * with area greater than AREA1.
     * 
     * Expected Behavior:
     * When provided with three consecutive point that create a triangle with area less than AREA1, the evaluation
     * method should return false.
     */
    @Test
    void LesserAreaConsecutive(){
        Parameters p = new Parameters();
        p.setAREA1(1.0);

        Point[] points = {
            new Point(0.0, 0.0),
            new Point(1.0, 0.0),
            new Point(1.0, 1.0)
        };
        Lic3 Lic3 = new Lic3();
        assertFalse(Lic3.evaluate(points, p));
    }
        /**
     * Contract:
     * There exists at least one set of three consecutive data points that are the vertices of a triangle
     * with area greater than AREA1.
     * 
     * Expected Behavior:
     * When provided with three consecutive point that create a triangle with area equal to AREA1, the evaluation
     * method should return false.
     */
    @Test
    void EqualAreaConsecutive(){
        Parameters p = new Parameters();
        p.setAREA1(2.0);

        Point[] points = {
            new Point(0.0, 0.0),
            new Point(2.0, 0.0),
            new Point(2.0, 2.0)
        };
        Lic3 Lic3 = new Lic3();
        assertFalse(Lic3.evaluate(points, p));
    }
}
