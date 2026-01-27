package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class Lic2Test {
    /**
     * Contract:
     * here exists at least one set of three consecutive data points which form an angle such that:
     * angle > (PI + EPSILON).
     * 
     * Expected Behavior:
     * When provided with three consecutive point that create an angle greater than PI + EPSILON, the evaluation
     * method should return true.
     */
    @Test
    void GreaterAngleConsecutive(){
        Parameters p = new Parameters();
        p.setEPSILON(0.0);

        Point[] points = {
            new Point(0.0, 0.0),
            new Point(1.0, 0.0),
            new Point(1.0, 1.0)
        };
        Lic2 Lic2 = new Lic2();
        assertTrue(Lic2.evaluate(points, p));
    }
        /**
     * Contract:
     * here exists at least one set of three consecutive data points which form an angle such that:
     * angle < (PI − EPSILON).
     * 
     * Expected Behavior:
     * When provided with three consecutive point that create an angle less than PI - EPSILON, the evaluation
     * method should return true.
     */
    @Test
    void LesserAngleConsecutive(){
        Parameters p = new Parameters();
        p.setEPSILON(1.0);

        Point[] points = {
            new Point(0.0, 0.0),
            new Point(1.0, 0.0),
            new Point(0.0, 1.0)
        };
        Lic2 Lic2 = new Lic2();
        assertTrue(Lic2.evaluate(points, p));
    }
        /**
     * Contract:
     * here exists at least one set of three consecutive data points which form an angle such that:
     * angle > (PI + EPSILON) or angle < (PI - EPSILON).
     * 
     * Expected Behavior:
     * When provided with three consecutive point that create an angle less than PI + EPSILON, but greater than PI - EPSILON, the evaluation
     * method should return false.
     */
    @Test
    void NoConsecutiveAngle(){
        Parameters p = new Parameters();
        p.setEPSILON(2.0);

        Point[] points = {
            new Point(0.0, 0.0),
            new Point(1.0, 0.0),
            new Point(1.0, 1.0)
        };

        Lic2 Lic2 = new Lic2();
        assertFalse(Lic2.evaluate(points, p));
    }
}