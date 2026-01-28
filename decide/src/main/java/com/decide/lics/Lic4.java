package com.decide.lics;

import java.util.ArrayList;

import com.decide.model.Parameters;
import com.decide.model.Point;

public final class Lic4 implements Lic {
    public Lic4() {
    }

    /**
     * Determine the quadrant of a point facoring quadrants of lower values first
     * @param p The point to evaluate
     * @return The quadrant number (1 to 4)
     */
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

    /**
     * Checks condition for LIC4
     * 
     * There exists at least one set of Q_PTS consecutive data points that lie in more than QUADS
     * quadrants. Where there is ambiguity as to which quadrant contains a given point, priority
     * of decision will be by quadrant number, i.e., I, II, III, IV. For example, the data point (0,0)
     * is in quadrant I, the point (-l,0) is in quadrant II, the point (0,-l) is in quadrant III, the point
     * (0,1) is in quadrant I and the point (1,0) is in quadrant I. (2 ≤ Q_PTS ≤ NUMPOINTS), (1 ≤ QUADS ≤ 3).
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if the condition is met, false otherwise
     */
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
        for (int i = 0; i < n - params.getQ_PTS(); i++){
            //Track number of unique quadrants in list l
            ArrayList<Integer> l = new ArrayList<>(); 
            for (int j = 0; j < params.getQ_PTS(); j++){
                int quadrant = decideQuad(points[j]);
                if(!l.contains(quadrant)){
                    l.add(quadrant);
                    //Determine the number of unique quadrants using .size()
                    if(l.size() > params.getQUADS()){
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
