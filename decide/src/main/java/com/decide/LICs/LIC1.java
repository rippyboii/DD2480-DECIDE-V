package com.decide.LICs;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;;
public final class LIC1 implements LIC {
    public LIC1() {
    }

    /**
     * Checks condition for LIC1
     * 
     * Checks if the points set contains three consecutive datapoints,
     * which cannot be contained within or on a circle of RADIUS1.
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if there e
     */
    @Override 
    public boolean evaluate(Point[] points, Parameters params) {
        int nPoints = points.length;
        if (nPoints < 3) { // i need a set of 3 points
            return false;
        }
        double rad;
        for (int i = 0; i <= nPoints-3; i++) {
            Point p1 = points[i];
            Point p2 = points[i+1];
            Point p3 = points[i+2];

            rad = MathHelp.calculateSmallestRadius(p1, p2, p3);
            if (rad > params.RADIUS1) { // cannot be contained
                return true;
            }
        }
        return false;
    }
}
