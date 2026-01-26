package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

public final class Lic13 implements Lic {
    public Lic13() {
    }

    /**
     * Checks condition for LIC13
     * 
     * There exists at least one set of three data points, separated by exactly A PTS and B PTS
     * consecutive intervening points, respectively, that cannot be contained within or on a circle of
     * radius RADIUS1. In addition, there exists at least one set of three data points (which can be
     * the same or different from the three data points just mentioned) separated by exactly A PTS
     * and B PTS consecutive intervening points, respectively, that can be contained in or on a
     * circle of radius RADIUS2. Both parts must be true for the LIC to be true. The condition is
     * not met when NUMPOINTS < 5.
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if the condition is met, false otherwise
     */
    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        int nPoints = points.length;
        if (nPoints < 5) {
            return false;
        }
        // check if the parameters are valid
        if (params.getA_PTS() < 1 || params.getB_PTS() < 1 || (params.getA_PTS() + params.getB_PTS() > nPoints-3)) {
            throw new IllegalArgumentException();
        }
        double rad;
        boolean cannotBeContained = false;
        boolean canBeContained = false;
        for (int i = 0; i + params.getA_PTS() + 2 + params.getB_PTS() < nPoints; i++) {
            Point p1 = points[i];
            Point p2 = points[i+params.getA_PTS() + 1];
            Point p3 = points[i+params.getA_PTS() + params.getB_PTS() + 2];

            rad = MathHelp.calculateSmallestRadius(p1, p2, p3);
            // update cannotBeContained and canBeContained if they are not already true
            if (rad > params.getRADIUS1() && !cannotBeContained) { 
                cannotBeContained = true;
            }
            if (rad <= params.getRADIUS2() && !canBeContained) {
                canBeContained = true;
            }
            if (canBeContained && cannotBeContained) {
                return true;
            }
        }
        return false;
    }
}
