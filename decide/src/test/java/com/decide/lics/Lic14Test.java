package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class Lic14Test {

    private static final int MIN_VALID_E_PTS = 1;
    private static final int MIN_VALID_F_PTS = 1;
    
    /**
     * Contract:
     * LIC 14 shall return false when NUMPOINTS < 5 since no valid
     * triple separated by E_PTS and F_PTS can exist.
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

        // Set E_PTS and F_PTS to minimum valid values and AREA1, AREA2 to 0
        Parameters params = new Parameters();
        params.E_PTS = MIN_VALID_E_PTS;
        params.F_PTS = MIN_VALID_F_PTS;
        params.AREA1 = 0.0;
        params.AREA2 = 0.0;

        // Assert
        assertFalse(new Lic14().evaluate(fourPoints, params));
    }


    /**
     * Contract:
     * LIC 14 shall return false iff only condition 1 is satisfied i.e., there 
     * exists a triangle with area greater than AREA1), but no triangle with 
     * area less than AREA2.
     * 
     * Expected Behavior:
     * If there exists a triangle with area greater than AREA1, but no triangle with
     * area less than AREA2, LIC 14 should return false.
     */
    @Test
    void returnsFalseWhenOnlyAreaGreaterThanArea1Exists() {
        // Triangle with area = 1 unit
        Point[] area_1_triangle = {
            new Point(0, 0), // Point A
            new Point(6, 9), 
            new Point(1, 0), // Point B (vertex)
            new Point(4, 2),
            new Point(1, 2)  // Point C
        };

        // Set E_PTS and F_PTS to minimum valid values
        Parameters params = new Parameters();
        params.E_PTS = MIN_VALID_E_PTS;
        params.F_PTS = MIN_VALID_F_PTS;
        params.AREA1 = 0.5; // Area greater than 0.5 exists
        params.AREA2 = 0.75; // No area less than 0.75 exists

        // Assert
        assertFalse(new Lic14().evaluate(area_1_triangle, params));
    }


    /**
     * Contract:
     * LIC 14 shall return false iff only condition 2 is satisfied i.e., there 
     * exists no triangle with area greater than AREA1), a triangle with 
     * area less than AREA2.
     * 
     * Expected Behavior:
     * If there exists a triangle with area less than AREA2, but no triangle with
     * area greater than AREA1, LIC 14 should return false.
     */
    @Test
    void returnsFalseWhenOnlyAreaLessThanArea2Exists() {
        // Triangle with area = 1 unit
        Point[] area_1_triangle = {
            new Point(0, 0), // Point A
            new Point(6, 9), 
            new Point(1, 0), // Point B (vertex)
            new Point(4, 2),
            new Point(1, 2)  // Point C
        };

        // Set E_PTS and F_PTS to minimum valid values
        Parameters params = new Parameters();
        params.E_PTS = MIN_VALID_E_PTS;
        params.F_PTS = MIN_VALID_F_PTS;
        params.AREA1 = 1.2; // No area greater than 1.2 exists
        params.AREA2 = 1.5; // Area less than 1.5 exists

        // Assert
        assertFalse(new Lic14().evaluate(area_1_triangle, params));
    }



    /**
     * Contract:
     * LIC 14 shall return true when both conditions are satisfied i.e., there exists
     * a triangle with area greater than AREA1, and a triangle with area less than AREA2.
     * 
     * Expected Behavior:
     * If there exists a triangle with area greater than AREA1, and a triangle with
     * area less than AREA2, LIC 14 should return true.
     */
    @Test
    void returnsTrueWhenBothAreaConditionsAreSatisfied() {
        // Triangle with area = 1 unit
        Point[] area_1_triangle = {
            new Point(0, 0), // Point A
            new Point(6, 9), 
            new Point(1, 0), // Point B (vertex)
            new Point(4, 2),
            new Point(1, 2)  // Point C
        };

        // Set E_PTS and F_PTS to minimum valid values
        Parameters params = new Parameters();
        params.E_PTS = MIN_VALID_E_PTS;
        params.F_PTS = MIN_VALID_F_PTS;
        params.AREA1 = 0.5; // Area greater than 0.5 exists
        params.AREA2 = 1.5; // Area less than 1.5 exists

        // Assert
        assertTrue(new Lic14().evaluate(area_1_triangle, params));
    }


    /**
     * Contract:
     * LIC 14 shall respect the constraints defined by E_PTS and F_PTS so that there must be
     * exactly E_PTS points between A and B, and exactly F_PTS points between B and C.
     * 
     * Expected Behavior:
     * With E_PTS = 2 and F_PTS = 1, and only 5 points there are not enough intervening
     * points to form a valid triple. Therefore, LIC 14 should return false.
     */
    @Test
    void returnsFalseWhenNotEnoughInterveningPointsForCAndD() {
        Point[] points = {
            new Point(0, 0), // Point A
            new Point(6, 9), 
            new Point(1, 0), // Point B (vertex)
            new Point(4, 2),
            new Point(1, 2)  // Point C
        };

        // Set E_PTS and F_PTS to actual number of intervening points
        Parameters params = new Parameters();
        params.E_PTS = 2;
        params.F_PTS = 1;
        params.AREA1 = 0.5;
        params.AREA2 = 1.5;

        // Assert
        assertFalse(new Lic14().evaluate(points, params));
    }
}