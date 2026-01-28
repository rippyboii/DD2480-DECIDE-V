package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

public final class Lic12 implements Lic {
    public Lic12() {
    }
    /**
     * Checks condition for LIC 12
     * 
     * There exists at least one set of two data points, separated by exactly K PTS consecutive
     * intervening points, which are a distance greater than the length, LENGTH1, apart.
     * In addition, there exists at least one set of two data points (which can be the same or different from
     * the two data points just mentioned), separated by exactly K PTS consecutive intervening
     * points, that are a distance less than the length, LENGTH2, apart. Both parts must be true
     * for the LIC to be true. The condition is not met when NUMPOINTS < 3.
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if the condition is met, false otherwise
     */
    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        int nPoints = points.length;
        if (nPoints < 3) {
            return false;
        }
        if (params.getK_PTS() > nPoints - 2) {
            throw new IllegalArgumentException("K_PTS must be smaller than NUMPOINTS - 2.");
        }
        boolean greaterThanLength1 = false;
        boolean lesserThanLength2 = false;
        for (int i = 0; i+params.getK_PTS() + 1 < nPoints; i++) {
            Point p1 = points[i];
            Point p2 = points[i+params.getK_PTS() + 1];
            double dist = MathHelp.calculateDistance(p1, p2);
            if (dist > params.getLENGTH1() && !greaterThanLength1) {
                greaterThanLength1 = true;
            }
            if (dist < params.getLENGTH2() && !lesserThanLength2) {
                lesserThanLength2 = true;
            }
            if (greaterThanLength1 && lesserThanLength2) {
                return true;
            }
        }
        
        return false;

    }
}
