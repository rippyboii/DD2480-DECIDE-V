package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class Lic4Test {
    /**
     * Contract:
     * There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
     * quadrants.
     * 
     * Expected Behavior:
     * When provided with Q PTS consecutive point that lie within more than QUADS quadrants, the evaluation
     * method should return true.
     */
    @Test
    void MoreQuadsConsecutive(){
        Parameters p = new Parameters();
        p.setQUADS(2);
        p.setQ_PTS(3);

        Point[] points = {
            new Point(0.0, 0.0),
            new Point(-1.0, 0.0),
            new Point(0.0, -1.0),
            new Point(0.0, 1.0),
            new Point(1.0, 0.0)
        };
        Lic4 Lic4 = new Lic4();
        assertTrue(Lic4.evaluate(points, p));
    }
    /**
     * Contract:
     * There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
     * quadrants.
     * 
     * Expected Behavior:
     * When provided with Q PTS consecutive point that lie within less than QUADS quadrants, the evaluation
     * method should return false.
     */
    @Test
    void LessQuadsConsecutive(){
        Parameters p = new Parameters();
        p.setQUADS(3);
        p.setQ_PTS(3);

        Point[] points = {
            new Point(0.0, 0.0),
            new Point(-1.0, 0.0),
            new Point(0.0, -1.0),
            new Point(0.0, 1.0),
            new Point(1.0, 0.0)
        };
        Lic4 Lic4 = new Lic4();
        assertFalse(Lic4.evaluate(points, p));
    }
    /**
     * Contract:
     * There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
     * quadrants.
     * 
     * Expected Behavior:
     * When provided with Q PTS point that lie within more than QUADS quadrants, but are not consecutive, the evaluation
     * method should return false.
     */
    @Test
    void MoreQuadsNonConsecutive(){
        Parameters p = new Parameters();
        p.setQUADS(2);
        p.setQ_PTS(3);

        Point[] points = {
            new Point(0.0, -1.0),
            new Point(0.0, 0.0),
            new Point(1.0, 0.0),            
            new Point(-1.0, 0.0),
            new Point(0.0, 1.0)

        };
        Lic4 Lic4 = new Lic4();
        assertFalse(Lic4.evaluate(points, p));
    }
    
}
