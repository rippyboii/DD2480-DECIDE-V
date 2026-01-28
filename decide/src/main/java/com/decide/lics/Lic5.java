package com.decide.lics;

import com.decide.model.Parameters;
import com.decide.model.Point;

public final class Lic5 implements Lic {

    public Lic5() {}

    /**
     * Checks condition for LIC5
     * 
     * There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such
     * that X[j] - X[i] < 0. (where i = j-1)
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if the condition is met, false otherwise
     */
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
