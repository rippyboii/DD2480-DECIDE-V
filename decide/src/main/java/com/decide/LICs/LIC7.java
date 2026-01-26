package com.decide.LICs;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

/**
 * LIC7:
 * There exists at least one set of two data points separated by exactly K PTS consecutive 
 * intervening points that are a distance greater than the length, LENGTH1, apart.
 */
public final class LIC7 implements LIC {

    public LIC7() {
    }

    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        if (points == null || params == null) {
            throw new IllegalArgumentException("Either points are not passed or parameters are not passed.");
        }

        final int n = points.length;
        
        if (n < 3) {
            return false; // Condition is NOT met if there are fewer than 3 points
        }
        else if (params.K_PTS > n - 2 || params.K_PTS < 1){
            return false; // Illegal K_PTS
        }
        
        for (int i = 0; i < n - params.K_PTS - 1; i++){
            if (MathHelp.calculateDistance(points[i], points[i + params.K_PTS + 1]) > params.LENGTH1){
                return true;
            }
        }
        return false;
    }
}
