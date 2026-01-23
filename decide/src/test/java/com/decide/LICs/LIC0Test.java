package com.decide.LICs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

class LIC0Test {

    private static Parameters paramsWithLength1(double length1) {
        Parameters p = new Parameters();
        p.LENGTH1 = length1;
        return p;
    }

    /**
     * Contract:
     * LIC0 requires at least 2 points to evaluate. With fewer than 2 points,
     * the condition cannot be met.
     *
     * Expected Behavior:
     * When provided with fewer than 2 points, the evaluate method shall return false.
     */
    @Test
    void returnsFalseWhenFewerThanTwoPoints() {
        Point[] points = {
                new Point(0.0, 0.0)
        };
        Parameters params = paramsWithLength1(0.0);
        LIC0 lic0 = new LIC0();
        assertFalse(lic0.evaluate(points, params));
    }

    /**
     * Contract:
     * LIC0 evaluates to true if at least one pair of consecutive points
     * has a distance strictly greater than LENGTH1.
     * Distance between (0,0) and (5,0) is 5
     *
     * Expected Behavior:
     * When at least one consecutive pair of points has distance > LENGTH1,
     * the evaluate method shall return true.
     */
    @Test
    void returnsTrueWhenAnyConsecutivePairDistanceGreaterThanLength1() {
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(5.0, 0.0),
        };
        Parameters params = paramsWithLength1(3.0);
        LIC0 lic0 = new LIC0();
        assertTrue(lic0.evaluate(points, params));
    }

    /**
     * Contract:
     * LIC0 evaluates to false if no consecutive pair of points has a distance
     * strictly greater than LENGTH1.
     * Consecutive distances given are 3 and 4, but LENGTH1 is 5 so neither is > 5
     *
     * Expected Behavior:
     * When all consecutive pairs have distances <= LENGTH1, the evaluate method
     * shall return false.
     */
    @Test
    void returnsFalseWhenNoConsecutivePairDistanceGreaterThanLength1() {
        Point[] points = {
                new Point(0.0, 0.0),
                new Point(3.0, 0.0),
                new Point(7.0, 0.0)
        };
        Parameters params = paramsWithLength1(5.0);
        LIC0 lic0 = new LIC0();
        assertFalse(lic0.evaluate(points, params));
    }
}

