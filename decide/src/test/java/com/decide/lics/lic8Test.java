package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class lic8Test {

    /**
     * Contract:
     * lic8 should return false when the number of points is < 5, as the condition cannot be met.
     *
     * Expected Behavior:
     * The function shall return false when the number of points supplied is 4.
    */
    @Test
    void returnsFalseWhenFewerThanFivePoints() {
        lic8 lic8 = new lic8();
        Point[] points = {new Point(0, 1),
                        new Point(0, 2),
                        new Point(0, 3),
                        new Point(0, 4)
        };
        Parameters params = new Parameters();
        params.RADIUS1 = 1;
        params.A_PTS = 1;
        params.B_PTS = 1;
        assertFalse(lic8.evaluate(points, params));
    }

    /**
     * Contract:
     * lic8 should return true if there exists a set of three datapoints,
     * separated by A_PTS and B_PTS intermediate points, which cannot be
     * contained within or on a circle of radius RADIUS1.
     *
     * Expected Behavior:
     * Given a set of points where the selected datapoints according to
     * A_PTS and B_PTS form a triangle that requires a circle with radius
     * greater than RADIUS1, the function shall return true.
     */
    @Test
    void returnsTrueWhenPointsCannotBeContained() {
        lic8 lic8 = new lic8();
        Point[] points = {new Point(0, 0), // p1
                        new Point(0, 2), // between
                        new Point(0, 10), // p2
                        new Point(0, 4), // between
                        new Point(10, 0) // p3
        };
        Parameters params = new Parameters();
        params.RADIUS1 = 4;
        params.A_PTS = 1;
        params.B_PTS = 1;
        assertTrue(lic8.evaluate(points, params));
    }
     /**
     * Contract:
     * lic8 should return false if all sets of three datapoints separated by
      * A_PTS and B_PTS intermediate points can be contained within or on a
     * circle of radius RADIUS1.
     *
     * Expected Behavior:
     * Given a set of points where the selected datapoints according to
     * A_PTS and B_PTS can be contained within or on a circle of radius
     * RADIUS1, the function shall return false.
     */
    @Test
    void returnsFalseWhenSeparatedPointsCanBeContained() {
        lic8 lic8 = new lic8();
        Point[] points = {
            new Point(0, 0),   // p1
            new Point(0.5, 0), // between
            new Point(1, 0),   // p2
            new Point(0.5, 0.5), // between
            new Point(0, 1)    // p3
        };
        Parameters params = new Parameters();
        params.A_PTS = 1;
        params.B_PTS = 1;
        params.RADIUS1 = 1;

        assertFalse(lic8.evaluate(points, params));
}

    }  
