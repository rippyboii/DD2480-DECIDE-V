package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class lic7Test {
    /**
     * Contract:
     * There exists at least one set of two data points separated by exactly K PTS consecutive 
     * intervening points that are a distance greater than the length, LENGTH1, apart. The condition 
     * is not met when NUMPOINTS < 3.
     * 
     * Expected Behavior:
     * When provided with 2 data points separated by exactly K PTS consecutive point that 
     * lie a distance greater than LENGTH1 apart, the evaluation method should return true.
     */
    @Test
    void GreaterDistance(){
        Parameters p = new Parameters();
        p.K_PTS = 2;
        p.LENGTH1 = 5.0;

        Point[] points = {
            new Point(1.0, 5.0),
            new Point(-1.0, 0.0),
            new Point(0.0, -1.0),
            new Point(0.0, 0.0),
            new Point(1.0, 0.0)
        };
        lic7 lic7 = new lic7();
        assertTrue(lic7.evaluate(points, p));
    }

    /**
     * Contract:
     * There exists at least one set of two data points separated by exactly K PTS consecutive 
     * intervening points that are a distance greater than the length, LENGTH1, apart. The condition 
     * is not met when NUMPOINTS < 3.
     * 
     * Expected Behavior:
     * When provided with 2 data points separated by only less than K PTS consecutive point that 
     * lie a distance greater than LENGTH1 apart, the evaluation method should return false.
     */
    @Test
    void NotConsecutive(){
        Parameters p = new Parameters();
        p.K_PTS = 2;
        p.LENGTH1 = 5.0;

        Point[] points = {
            new Point(1.0, 5.0),
            new Point(-1.0, 0.0),
            new Point(0.0, -6.0),
            new Point(0.0, 3.0),
            new Point(1.0, 0.0)
        };
        lic7 lic7 = new lic7();
        assertFalse(lic7.evaluate(points, p));
    }

    /**
     * Contract:
     * There exists at least one set of two data points separated by exactly K PTS consecutive 
     * intervening points that are a distance greater than the length, LENGTH1, apart. The condition 
     * is not met when NUMPOINTS < 3.
     * 
     * Expected Behavior:
     * When provided with 2 data points separated by exactly K PTS consecutive point that 
     * lie a distance greater than LENGTH1 apart, the evaluation method should return true.
     */
    @Test
    void LesserDistance(){
        Parameters p = new Parameters();
        p.K_PTS = 2;
        p.LENGTH1 = 5.0;

        Point[] points = {
            new Point(1.0, 5.0),
            new Point(-1.0, 0.0),
            new Point(0.0, -1.0),
            new Point(0.0, 3.0),
            new Point(1.0, 0.0)
        };
        lic7 lic7 = new lic7();
        assertFalse(lic7.evaluate(points, p));
    }
    
}