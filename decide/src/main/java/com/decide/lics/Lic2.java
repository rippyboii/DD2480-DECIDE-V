package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

public final class Lic2 implements Lic {
    public Lic2() {
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

        for (int i = 0; i < n - 2; i++) {
            double angle = MathHelp.angleRadians(points[i].x(), points[i].y(), points[i + 1].x(), points[i + 1].y(), points[i + 2].x(), points[i + 2].y());
            if (angle > Math.PI + params.getEPSILON() || angle < Math.PI - params.getEPSILON()) {
                return true;
            }
        }

        return false;
    }
}
