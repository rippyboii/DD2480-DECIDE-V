package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class lic9Test {

    private static final int MIN_VALID_C_PTS = 1;
    private static final int MIN_VALID_D_PTS = 1;
    
    /**
     * Contract:
     * lic9 shall return false when NUMPOINTS < 5 since no valid
     * triple separated by C_PTS and D_PTS can exist.
     * 
     * Expected Behavior:
     * With only 4 points, the condition is not met by definition.
     */
    @Test
    void returnsFalseWhenNumPointsLessThan5() {
        Point[] fourPoints = {
            new Point(0, 0),
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3)
        };

        // Set C_PTS and D_PTS to minimum valid values
        Parameters params = new Parameters();
        params.C_PTS = MIN_VALID_C_PTS;
        params.D_PTS = MIN_VALID_D_PTS;

        // Assert
        assertFalse(new lic9().evaluate(fourPoints, params));
    }


    /**
     * Contract:
     * LIC 9 shall return true iff there exists at least one triple of points
     * separated by exactly C_PTS and D_PTS consecutive intervening points, 
     * forming an angle such that angle < (PI - EPSILON) OR angle > (PI + EPSILON).
     * 
     * Expected Behavior:
     * Points A(0,0), B(1,0), C(1,1) form a 90 degree angle (PI/2), which is clearly
     * less than (PI - EPSILON) for any reasonable EPSILON. Therefore, LIC 9 
     * should return true.
     */
    @Test
    void returnsTrueWhenAngleLessThanPiMinusEpsilon() {

        Point[] points = {
            new Point(0, 0), // Point A
            new Point(6, 9), 
            new Point(1, 0), // Point B (vertex)
            new Point(4, 2),
            new Point(1, 1)  // Point C
        };

        // Set C_PTS and D_PTS to actual number of intervening points
        Parameters params = new Parameters();
        params.C_PTS = 1;
        params.D_PTS = 1;
        params.EPSILON = 0.1; // Small epsilon

        // Assert
        assertTrue(new lic9().evaluate(points, params));
    }

    /**
     * Contract:
     * LIC 9 shall return false if no valid triple produces an angle outside the
     * range [PI - EPSILON, PI + EPSILON].
     * 
     * Expected Behavior:
     * Points A(0,0), B(1,0), C(2,0) are collinear and form a straight angle (PI),
     * which is within the range. Therefore, LIC 9 should return false.
     */
    @Test
    void returnsFalseWhenNoAngleOutsidePiPlusMinusEpsilon() {
        Point[] points = {
            new Point(0, 0), // Point A
            new Point(6, 9),
            new Point(1, 0), // Point B (vertex)
            new Point(4, 2),
            new Point(2, 0)  // Point C
        };

        // Set C_PTS and D_PTS to actual number of intervening points
        Parameters params = new Parameters();
        params.C_PTS = 1;
        params.D_PTS = 1;
        params.EPSILON = 0.1; // Small epsilon

        // Assert
        assertFalse(new lic9().evaluate(points, params));
    }


    /**
     * Contract:
     * If either the first or last point coincides with the vertex point of the angle,
     * the angle is undefined, and LIC 9 is not satisfied by that triple of points.
     * 
     * Expected Behavior:
     * A == B, so vector BA has zero length, making the angle undefined. 
     * Therefore, LIC 9 should return false.
     */
    @Test
    void returnsFalseWhenAngleIsUndefinedDueToCoincidingPoints() {
        Point[] points = {
            new Point(1, 1), // Point A
            new Point(6, 9),
            new Point(1, 1), // Point B (vertex) coincides with A
            new Point(4, 2),
            new Point(2, 0)  // Point C
        };

        // Set C_PTS and D_PTS to actual number of intervening points
        Parameters params = new Parameters();
        params.C_PTS = 1;
        params.D_PTS = 1;
        params.EPSILON = 0.1; // Small epsilon

        // Assert
        assertFalse(new lic9().evaluate(points, params));
    }

    /**
     * Contract:
     * LIC 9 shall respect the constraints defined by C_PTS and D_PTS so that there must be
     * exactly C_PTS points between A and B, and exactly D_PTS points between B and C.
     * 
     * Expected Behavior:
     * With C_PTS = 2 and D_PTS = 1, and only 5 pointsthere are not enough intervening
     * points to form a valid triple. Therefore, LIC 9 should return false.
     */
    @Test
    void returnsFalseWhenNotEnoughInterveningPointsForCAndD() {
        Point[] points = {
            new Point(0, 0), // Point A
            new Point(6, 9), 
            new Point(1, 0), // Point B (vertex)
            new Point(4, 2),
            new Point(1, 1)  // Point C
        };

        // Set C_PTS and D_PTS to actual number of intervening points
        Parameters params = new Parameters();
        params.C_PTS = 2;
        params.D_PTS = 1;
        params.EPSILON = 0.1; // Small epsilon

        // Assert
        assertFalse(new lic9().evaluate(points, params));
    }
}

