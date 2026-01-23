package com.decide.LICs;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

/**
 * LIC0:
 * There exists at least one set of two consecutive data points
 * that are a distance greater than LENGTH1 apart.
 *
 * Condition is NOT met if NUMPOINTS < 2.
 */
public final class LIC0 implements LIC {

    private LIC0() {
    }

    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        if (points == null || params == null) {
            throw new IllegalArgumentException("Either points are not passed or parameters are not passed.");
        }

        final int n = points.length;
        
        if (n < 2) {
            return false; // Condition is NOT met if there are fewer than 2 points
        }

        for (int i = 0; i < n - 1; i++) {
            double d = MathHelp.calculateDistance(points[i], points[i + 1]);
            if (d > params.LENGTH1) {
                return true;
            }
        }

        return false;
    }
}
