package com.decide.lics;

import com.decide.model.Parameters;
import com.decide.model.Point;

public final class lic5 implements lic {

    public lic5() {}

    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        // Validate input
        if (points == null || points.length < 2) {
            return false;
        }

        // Check for at least one pair of consecutive points where X[i+1] < X[i]
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i+1].x() < points[i].x()) {
                return true;
            }
        }
        return false;
    }    
}
