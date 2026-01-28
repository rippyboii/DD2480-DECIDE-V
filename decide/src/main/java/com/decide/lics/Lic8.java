package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

public final class Lic8 implements Lic {
    public Lic8() {
    }
     /**
     * Checks condition for LIC8.
     *
     * Checks if the points set contains three datapoints separated by
     * A_PTS and B_PTS intermediate points, which cannot be contained
     * within or on a circle of radius RADIUS1.
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if the condition is met, false otherwise
     */
    @Override 
    public boolean evaluate(Point[] points, Parameters params) {
        int nPoints = points.length;
        if (nPoints < 5){ // We need at least 5 points
            return false;
        }
        int maxI = nPoints - (params.getA_PTS() + params.getB_PTS() + 3); //max i depends on parameters A_PTS and B_PTS
        for (int i = 0; i <= maxI; i++) {
            Point p1 = points[i];
            Point p2 = points[i + params.getA_PTS() + 1];
            Point p3 = points[i + params.getA_PTS() + params.getB_PTS() + 2]; 

            double rad = MathHelp.calculateSmallestRadius(p1, p2, p3);
            if (rad > params.getRADIUS1()){
                return true; // Set of points can not be contained
            }
        }
        return false;
    }
}

        
