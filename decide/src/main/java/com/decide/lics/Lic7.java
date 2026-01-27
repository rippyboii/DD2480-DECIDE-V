package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

/**
 * LIC7:
 * There exists at least one set of two data points separated by exactly K PTS consecutive 
 * intervening points that are a distance greater than the length, LENGTH1, apart.
 */
public final class Lic7 implements Lic {

    public Lic7() {
    }

    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        if (points == null || params == null) {
            throw new IllegalArgumentException("Either points are not passed or parameters are not passed.");
        }

        final int n = points.length;
        
        if (n < 3) {
            return false; // Condition is NOT met if there are fewer than 3 points
        }
        else if (params.getK_PTS() > n - 2 || params.getK_PTS() < 1){
            return false; // Illegal K_PTS
        }
        
        for (int i = 0; i < n - params.getK_PTS() - 1; i++){
            if (MathHelp.calculateDistance(points[i], points[i + params.getK_PTS() + 1]) > params.getLENGTH1()){
                return true;
            }
        }
        return false;
    }
}
