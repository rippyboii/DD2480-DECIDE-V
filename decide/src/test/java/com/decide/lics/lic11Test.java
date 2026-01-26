package com.decide.lics;

import com.decide.model.Point;
import com.decide.model.Parameters;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class lic11Test {

/**
 * Contract:
 * lic11 should return false when NUMPOINTS < 3.
 *
 * Expected Behavior:
 * Given only 2 points, the condition cannot be met. Therefore, lic11 must return false.
 */
    @Test
    public void testNotEnoughPoints() {
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(1, 1)
        };
        Parameters params = new Parameters();
        params.G_PTS = 1;

        assertFalse(lic11.evaluate(points, params));
    }



/**
 * Contract:
 * lic11 should return false if X[j] - X[i] >= 0 for all valid pairs.
 *
 * Expected Behavior:
 * For points with non-decreasing x-coordinates, no pair satisfies X[j] - X[i] < 0.
 * Therefore, lic11 must return false.
 */
    @Test
    public void testConditionNotMet() {
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3)
        };
        Parameters params = new Parameters();
        params.G_PTS = 1;

        assertFalse(lic11.evaluate(points, params));
    }

/**
 * Contract:
 * lic11 should return false when X[j] - X[i] = 0, since 0 is not less than 0.
 *
 * Expected Behavior:
 * For points (5,0), (3,1), (5,2) with G_PTS = 1, X[2] - X[0] = 5 - 5 = 0.
 * Since 0 is not < 0, lic11 must return false.
 */
    @Test
    public void testEqualXCoordinates() {
        Point[] points = new Point[]{
            new Point(5, 0),
            new Point(3, 1),
            new Point(5, 2)
        };
        Parameters params = new Parameters();
        params.G_PTS = 1;

        assertFalse(lic11.evaluate(points, params));
    }

/**
 * Contract:
 * lic11 should correctly handle larger G_PTS values.
 *
 * Expected Behavior:
 * For points (10,0), (5,1), (6,2), (3,3) with G_PTS = 2, X[3] - X[0] = 3 - 10 = -7 < 0.
 * Therefore, lic11 must return true.
 */
    @Test
    public void testWithLargerGPts() {
        Point[] points = new Point[]{
            new Point(10, 0),
            new Point(5, 1),
            new Point(6, 2),
            new Point(3, 3)
        };
        Parameters params = new Parameters();
        params.G_PTS = 2;

        assertTrue(lic11.evaluate(points, params));
    }
}
