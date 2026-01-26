package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class lic5Test {

    private static final Parameters params = new Parameters();

    /**
     * Contract:
     * LIC 5 shall return TRUE iff there exists at least one pair of consecutive
     * data points (X[i], Y[i]) and (X[i+1], Y[i+1]), such that X[i+1] - X[i] < 0.
     * 
     * Expected behavior:
     * When one consecutive pair of points has X[i+1] < X[i], lic5 returns TRUE.
     */
    @Test
    void testlic5TrueWithOneConsecutiveDecreasingPair() {
        lic5 lic5 = new lic5();
        
        Point[] points = {
            new Point(1.0, 2.0),
            new Point(1.5, 1.0),
            new Point(0.5, 3.0), // X decreases here
            new Point(2.0, 4.0)
        };

        // Assert
        assertTrue(lic5.evaluate(points, params));
    }

    /**
     * Contract:
     * LIC 5 shall return TRUE iff there exists at least one pair of consecutive
     * data points (X[i], Y[i]) and (X[i+1], Y[i+1]), such that X[i+1] - X[i] < 0.
     * 
     * Expected behavior:
     * When multiple pairs of points have decreasing X-values, lic5 returns TRUE.
     */
    @Test
    void testlic5TrueWithMultipleDecreasingPairs() {
        lic5 lic5 = new lic5();
        
        Point[] points = {
            new Point(2.0, 2.0),
            new Point(1.8, 3.0),  // X decreases here
            new Point(1.5, 1.0),  // X decreases here
            new Point(-0.2, 4.0), // X decreases here
            new Point(3.0, -5.0)
        };

        // Assert
        assertTrue(lic5.evaluate(points, params));
    }

    /**
     * Contract:
     * LIC 5 shall return TRUE iff there exists at least one pair of consecutive
     * data points (X[i], Y[i]) and (X[i+1], Y[i+1]), such that X[i+1] - X[i] < 0.
     * 
     * Expected behavior:
     * When no consecutive pair of points has X[i+1] < X[i], lic5 returns FALSE.
     */
    @Test
    void testlic5FalseWithNoConsecutiveDecreasingPairs() {
        lic5 lic5 = new lic5();
        
        Point[] points = {
            new Point(1.0, 2.0),
            new Point(2.0, 3.0),
            new Point(3.0, 1.0),
            new Point(4.0, 4.0)
        };

        // Assert
        assertFalse(lic5.evaluate(points, params));
    }


    /**
     * Contract:
     * LIC 5 shall require a strict decrease in X-values.
     * 
     * Expected behavior:
     * When X[i+1] == X[i] for all consecutive pairs, lic5 returns FALSE.
     */
    @Test
    void testlic5FalseWithEqualXValues() {
        lic5 lic5 = new lic5();

        Point[] points = {
            new Point(1.0, 2.0),
            new Point(1.0, 3.0),
            new Point(1.0, 1.0),
            new Point(1.0, 4.0)
        };

        // Assert
        assertFalse(lic5.evaluate(points, params));
    }

    /**
     * Contract:
     * LIC 5 shall return FALSE when there are insufficient points.
     * 
     * Expected behavior:
     * When there is only one point, lic5 returns FALSE.
     */
    @Test
    void testlic5FalseWithSinglePoint() {
        lic5 lic5 = new lic5();

        Point[] points = {
            new Point(1.0, 2.0)
        };

        // Assert
        assertFalse(lic5.evaluate(points, params));
    }
}