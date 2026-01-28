package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

public final class Lic3 implements Lic {
    public Lic3() {
    }

    /**
     * Checks condition for LIC3
     * 
     * There exists at least one set of three consecutive data points that are the vertices of a triangle
     * with area greater than AREA1. (0 <= AREA1)
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if the condition is met, false otherwise
     */
    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        if (points == null || params == null) {
            throw new IllegalArgumentException("Either points are not passed or parameters are not passed.");
        }

        final int n = points.length;
        
        if (n < 2) {
            return false; // Condition is NOT met if there are fewer than 2 points
        }

        for (int i = 0; i < n - 2; i++) {
            double area = MathHelp.triangleArea(points[i], points[i + 1], points[i + 2]);
            if (area > params.getAREA1()) {
                return true;
            }
        }

        return false;
    }    
}
