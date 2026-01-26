package com.decide.LICs;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

public final class LIC8 implements LIC {
    public LIC8() {
    }
     /**
     * Checks condition for LIC8.
     *
     * Checks if the points set contains three datapoints separated by
     * A_PTS and B_PTS intermediate points, which cannot be contained
     * within or on a circle of radius RADIUS1.
     */

    @Override 
    public boolean evaluate(Point[] points, Parameters params) {
        int nPoints = points.length;
        if (nPoints < 5){ // We need at least 5 points
            return false;
        }
        int maxI = nPoints - (params.A_PTS + params.B_PTS + 3); //max i depends on parameters A_PTS and B_PTS
        for (int i = 0; i <= maxI; i++) {
            Point p1 = points[i];
            Point p2 = points[i + params.A_PTS + 1];
            Point p3 = points[i + params.A_PTS + params.B_PTS + 2]; 

            double rad = MathHelp.calculateSmallestRadius(p1, p2, p3);
            if (rad > params.RADIUS1){
                return true; // Set of points can not be contained
            }
        }
        return false;
    }
}

        
