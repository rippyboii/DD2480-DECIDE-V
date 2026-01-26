package com.decide.LICs;

import com.decide.model.Parameters;
import com.decide.model.Point;


public class LIC11 implements LIC {
    public LIC11() {
    }
    
    @Override
    public boolean evaluate(Point[] points, Parameters params) {

        int NUMPOINTS = points.length;
        int G_PTS = params.G_PTS;

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