package com.decide.LICs;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

public final class LIC10 implements LIC {
    public LIC10() {
    }
     /**
     * Checks condition for LIC10.
     *
     * Checks if there exists at least one set of three datapoints separated by
     * exactly E_PTS and F_PTS consecutive intervening points that are the vertices
     * of a triangle with area greater than AREA1.
     *
     * The condition is not met when NUMPOINTS < 5.
     */
    @Override 
    public boolean evaluate(Point[] points, Parameters params) {
        int nPoints = points.length;
        if (nPoints < 5){ // We need at least 5 points
            return false;
        }
        if (params.E_PTS < 1 || params.F_PTS < 1) {
            return false;
            }

        if (params.E_PTS + params.F_PTS > nPoints - 3) {
            return false;
            }

        int maxI = nPoints - (params.E_PTS + params.F_PTS + 3); //max i depends on parameters E_PTS and F_PTS
        for (int i = 0; i <= maxI; i++) {
            Point p1 = points[i];
            Point p2 = points[i + params.E_PTS + 1];
            Point p3 = points[i + params.E_PTS + params.F_PTS + 2]; 

            double area = MathHelp.triangleArea(p1, p2, p3);
            if (area > params.AREA1){
                return true; // Triangle area exceeds AREA1
            }
        }
        return false;
    }
}

        
