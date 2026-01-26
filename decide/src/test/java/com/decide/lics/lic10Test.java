package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class lic10Test {

    /**
     * Contract:
     * lic10 should return false when the number of points is < 5, as the condition cannot be met.
     *
     * Expected Behavior:
     * The function shall return false when the number of points supplied is 4.
     */
    @Test
    void returnsFalseWhenFewerThanFivePoints() {
        lic10 lic10 = new lic10();

        Point[] points = {
            new Point(0, 1),
            new Point(0, 2),
            new Point(0, 3),
            new Point(0, 4)
        };

        Parameters params = new Parameters();
        params.E_PTS = 1;
        params.F_PTS = 1;
        params.AREA1 = 1;

        assertFalse(lic10.evaluate(points, params));
    }

    /**
     * Contract:
     * lic10 should return true if there exists at least one set of three datapoints separated by
     * exactly E_PTS and F_PTS consecutive intervening points that are the vertices of a triangle
     * with area greater than AREA1.
     *
     * Expected Behavior:
     * Given a set of points where the selected datapoints according to E_PTS and F_PTS form a
     * triangle with area greater than AREA1, the function shall return true.
     */
    @Test
    void returnsTrueWhenSeparatedPointsFormTriangleWithAreaGreaterThanAREA1() {
        lic10 lic10 = new lic10();

        /*
         * E_PTS = 1, F_PTS = 1
         * Indices tested: 0, 2, 4
         * Triangle area for (0,0), (0,10), (10,0) is 50.
         */
        Point[] points = {
            new Point(0, 0),   // p1
            new Point(1, 1),   // between
            new Point(0, 10),  // p2
            new Point(2, 2),   // between
            new Point(10, 0)   // p3
        };

        Parameters params = new Parameters();
        params.E_PTS = 1;
        params.F_PTS = 1;
        params.AREA1 = 40;

        assertTrue(lic10.evaluate(points, params));
    }

    /**
     * Contract:
     * lic10 should return false if all sets of three datapoints separated by exactly E_PTS and
     * F_PTS consecutive intervening points form triangles with area less than or equal to AREA1.
     *
     * Expected Behavior:
     * Given a set of points where the selected datapoints according to E_PTS and F_PTS can only
     * form triangles with area less than or equal to AREA1, the function shall return false.
     */
    @Test
    void returnsFalseWhenSeparatedPointsDoNotExceedAREA1() {
        lic10 lic10 = new lic10();

        /*
         * E_PTS = 1, F_PTS = 1
         * Indices tested: 0, 2, 4
         * Triangle area for (0,0), (1,0), (0,1) is 0.5.
         */
        Point[] points = {
            new Point(0, 0),     // p1
            new Point(0.5, 0),   // between
            new Point(1, 0),     // p2
            new Point(0.5, 0.5), // between
            new Point(0, 1)      // p3
        };

        Parameters params = new Parameters();
        params.E_PTS = 1;
        params.F_PTS = 1;
        params.AREA1 = 1;

        assertFalse(lic10.evaluate(points, params));
    }

       /**
     * Contract:
     * lic10 should return false when parameter constraints are violated (E_PTS < 1 or F_PTS < 1).
     *
     * Expected Behavior:
     * Given valid points but an invalid E_PTS (0), the function shall return false.
     */
    @Test
    void returnsFalseWhenEptsOrFptsIsLessThanOne() {
        lic10 lic10 = new lic10();

        Point[] points = {
            new Point(0, 0),
            new Point(1, 1),
            new Point(0, 10),
            new Point(2, 2),
            new Point(10, 0)
        };

        Parameters params = new Parameters();
        params.E_PTS = 0;   // invalid
        params.F_PTS = 1;
        params.AREA1 = 1;

        assertFalse(lic10.evaluate(points, params));
    }

    /**
     * Contract:
     * lic10 should return false when parameter constraints are violated
     * (E_PTS + F_PTS > NUMPOINTS - 3).
     *
     * Expected Behavior:
     * Given NUMPOINTS = 5 and E_PTS + F_PTS = 3, no valid triplet can be formed,
     * and the function shall return false.
     */
    @Test
    void returnsFalseWhenEptsPlusFptsTooLargeForNumpoints() {
        lic10 lic10 = new lic10();

        Point[] points = {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0),
            new Point(4, 0)
        };

        Parameters params = new Parameters();
        params.E_PTS = 2;
        params.F_PTS = 1; // 2 + 1 = 3 > (5 - 3) = 2 => invalid
        params.AREA1 = 0.1;

        assertFalse(lic10.evaluate(points, params));
    }
}
