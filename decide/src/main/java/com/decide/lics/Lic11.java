package com.decide.lics;

import com.decide.model.Parameters;
import com.decide.model.Point;


public final class Lic11 implements Lic {
    public Lic11() {
    }
    
    /**
     * Checks condition for LIC11
     * 
     * There exists at least one set of two data points, (X[i],Y[i]) and (X[j],Y[j]), separated by
     * exactly G_PTS consecutive intervening points, such that X[j] - X[i] < 0. (where i < j ) The
     * condition is not met when NUMPOINTS < 3.
     * 1 ≤ G_PTS ≤ NUMPOINTS−2
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if the condition is met, false otherwise
     */
    @Override
    public boolean evaluate(Point[] points, Parameters params) {

        int NUMPOINTS = points.length;
        int G_PTS = params.getG_PTS();

        if (NUMPOINTS < 3) {
            return false;
        }

        for (int i = 0; i < NUMPOINTS - G_PTS - 1; i++) {
            int j = i + G_PTS + 1;
            if (points[j].x() - points[i].x() < 0) {
                return true;
            }
        }

        return false;
    }   
}