package com.decide.LICs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

class LIC10Test {

    /**
     * Contract:
     * LIC10 should return false when the number of points is < 5, as the condition cannot be met.
     *
     * Expected Behavior:
     * The function shall return false when the number of points supplied is 4.
     */
    @Test
    void returnsFalseWhenFewerThanFivePoints() {
        LIC10 lic10 = new LIC10();

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
     * LIC10 should return true if there exists at least one set of three datapoints separated by
     * exactly E_PTS and F_PTS consecutive intervening points that are the vertices of a triangle
     * with area greater than AREA1.
     *
     * Expected Behavior:
     * Given a set of points where the selected datapoints according to E_PTS and F_PTS form a
     * triangle with area greater than AREA1, the function shall return true.
     */
    @Test
    void returnsTrueWhenSeparatedPointsFormTriangleWithAreaGreaterThanAREA1() {
        LIC10 lic10 = new LIC10();

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
     * LIC10 should return false if all sets of three datapoints separated by exactly E_PTS and
     * F_PTS consecutive intervening points form triangles with area less than or equal to AREA1.
     *
     * Expected Behavior:
     * Given a set of points where the selected datapoints according to E_PTS and F_PTS can only
     * form triangles with area less than or equal to AREA1, the function shall return false.
     */
    @Test
    void returnsFalseWhenSeparatedPointsDoNotExceedAREA1() {
        LIC10 lic10 = new LIC10();

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
}
