package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

public final class Lic2 implements Lic {
    public Lic2() {
    }

    /**
     * Checks condition for LIC2
     * 
     * There exists at least one set of three consecutive data points which form an angle such that:
     * angle < (PI - EPSILON) or angle > (PI + EPSILON).
     * 
     * The second of the three consecutive points is always the vertex of the angle. If either the first
     * point or the last point (or both) coincides with the vertex, the angle is undefined and the LIC
     * is not satisfied by those three points.
     * (0 <= EPSILON < PI)
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
            double angle = MathHelp.angleRadians(points[i].x(), points[i].y(), points[i + 1].x(), points[i + 1].y(), points[i + 2].x(), points[i + 2].y());
            if (angle > Math.PI + params.getEPSILON() || angle < Math.PI - params.getEPSILON()) {
                return true;
            }
        }

        return false;
    }
}
