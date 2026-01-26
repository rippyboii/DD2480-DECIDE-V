package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class Lic5Test {

    private static final Parameters params = new Parameters();

    /**
     * Contract:
     * LIC 5 shall return TRUE iff there exists at least one pair of consecutive
     * data points (X[i], Y[i]) and (X[i+1], Y[i+1]), such that X[i+1] - X[i] < 0.
     * 
     * Expected behavior:
     * When one consecutive pair of points has X[i+1] < X[i], Lic5 returns TRUE.
     */
    @Test
    void testLic5TrueWithOneConsecutiveDecreasingPair() {
        Lic5 Lic5 = new Lic5();
        
        Point[] points = {
            new Point(1.0, 2.0),
            new Point(1.5, 1.0),
            new Point(0.5, 3.0), // X decreases here
            new Point(2.0, 4.0)
        };

        // Assert
        assertTrue(Lic5.evaluate(points, params));
    }

    /**
     * Contract:
     * LIC 5 shall return TRUE iff there exists at least one pair of consecutive
     * data points (X[i], Y[i]) and (X[i+1], Y[i+1]), such that X[i+1] - X[i] < 0.
     * 
     * Expected behavior:
     * When multiple pairs of points have decreasing X-values, Lic5 returns TRUE.
     */
    @Test
    void testLic5TrueWithMultipleDecreasingPairs() {
        Lic5 Lic5 = new Lic5();
        
        Point[] points = {
            new Point(2.0, 2.0),
            new Point(1.8, 3.0),  // X decreases here
            new Point(1.5, 1.0),  // X decreases here
            new Point(-0.2, 4.0), // X decreases here
            new Point(3.0, -5.0)
        };

        // Assert
        assertTrue(Lic5.evaluate(points, params));
    }

    /**
     * Contract:
     * LIC 5 shall return TRUE iff there exists at least one pair of consecutive
     * data points (X[i], Y[i]) and (X[i+1], Y[i+1]), such that X[i+1] - X[i] < 0.
     * 
     * Expected behavior:
     * When no consecutive pair of points has X[i+1] < X[i], Lic5 returns FALSE.
     */
    @Test
    void testLic5FalseWithNoConsecutiveDecreasingPairs() {
        Lic5 Lic5 = new Lic5();
        
        Point[] points = {
            new Point(1.0, 2.0),
            new Point(2.0, 3.0),
            new Point(3.0, 1.0),
            new Point(4.0, 4.0)
        };

        // Assert
        assertFalse(Lic5.evaluate(points, params));
    }


    /**
     * Contract:
     * LIC 5 shall require a strict decrease in X-values.
     * 
     * Expected behavior:
     * When X[i+1] == X[i] for all consecutive pairs, Lic5 returns FALSE.
     */
    @Test
    void testLic5FalseWithEqualXValues() {
        Lic5 Lic5 = new Lic5();

        Point[] points = {
            new Point(1.0, 2.0),
            new Point(1.0, 3.0),
            new Point(1.0, 1.0),
            new Point(1.0, 4.0)
        };

        // Assert
        assertFalse(Lic5.evaluate(points, params));
    }

    /**
     * Contract:
     * LIC 5 shall return FALSE when there are insufficient points.
     * 
     * Expected behavior:
     * When there is only one point, Lic5 returns FALSE.
     */
    @Test
    void testLic5FalseWithSinglePoint() {
        Lic5 Lic5 = new Lic5();

        Point[] points = {
            new Point(1.0, 2.0)
        };

        // Assert
        assertFalse(Lic5.evaluate(points, params));
    }
}