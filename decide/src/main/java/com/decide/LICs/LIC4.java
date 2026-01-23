package com.decide.LICs;

import java.util.ArrayList;

import com.decide.model.Parameters;
import com.decide.model.Point;

public final class LIC4 implements LIC {
    private LIC4() {
    }
    // Determine the quadrant of a point facoring quadrants of lower values first
    private static int decideQuad(Point p){
        if (p.x() >= 0.0 && p.y() >= 0.0){
            return 1;
        }
        else if(p.x() <= 0.0 && p.y() >= 0.0){
            return 2;
        }
        else if(p.x() <= 0.0 && p.y() <= 0.0){
            return 3;
        }
        else{
            return 4;
        }
    }
    @Override
    public boolean evaluate(Point[] points, Parameters params) {

        if (points == null || params == null) {
            throw new IllegalArgumentException("Either points are not passed or parameters are not passed.");
        }

        final int n = points.length;

        
        if (n < 2) {
            return false; // Condition is NOT met if there are fewer than 2 points
        }
        // Check all sets of Q_PTS consecutive points
        for (int i = 0; i < n - params.Q_PTS; i++){
            //Track number of unique quadrants in list l
            ArrayList<Integer> l = new ArrayList<>(); 
            for (int j = 0; j < params.Q_PTS; j++){
                int quadrant = decideQuad(points[j]);
                if(!l.contains(quadrant)){
                    l.add(quadrant);
                    //Determine the number of unique quadrants using .size()
                    if(l.size() > params.QUADS){
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
