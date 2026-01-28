package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;


public final class Lic6 implements Lic {
    public Lic6() {
    }
    
    /**
     * Checks condition for LIC6
     * 
     * There exists at least one set of N_PTS consecutive data points such that at least one of the
     * points lies a distance greater than DIST from the line joining the first and last of these N_PTS
     * points. If the first and last points of these N_PTS are identical, then the calculated distance
     * to compare with DIST will be the distance from the coincident point to all other points of
     * the N_PTS consecutive points. The condition is not met when NUMPOINTS < 3.
     * (3 ≤ N_PTS ≤ NUMPOINTS), (0 ≤ DIST)
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if the condition is met, false otherwise
     */
    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        if (points == null || params == null) {
            throw new IllegalArgumentException("Either your points or parameters are null");
        }

        int n = points.length;
        int N_PTS = params.getN_PTS();
        double DIST = params.getDIST();

        if (n < N_PTS) {
            return false;
        }

        for (int i = 0; i <= n - N_PTS; i++) {
            Point A = points[i];
            Point B = points[i + N_PTS - 1];

            for (int j = i + 1; j < i + N_PTS - 1; j++) {
                double d = MathHelp.pointToLineDistance(A, B, points[j]);
                if (d > DIST) {
                    return true;
                }
            }
        }

        return false;
    }
}
