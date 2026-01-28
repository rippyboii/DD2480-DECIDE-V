package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Point;
import com.decide.model.Parameters;

public final class Lic9 implements Lic {

    public Lic9() {}

    /**
     * Checks condition for LIC9
     * 
     * There exists at least one set of three data points separated by exactly C PTS and D PTS
     * consecutive intervening points, respectively, that form an angle such that:
     * angle < (PI−EPSILON) or angle > (PI+EPSILON).
     * 
     * The second point of the set of three points is always the vertex of the angle. If either the first
     * point or the last point (or both) coincide with the vertex, the angle is undefined and the LIC
     * is not satisfied by those three points. When NUMPOINTS < 5, the condition is not met.
     * 1 ≤ C_PTS, 1 ≤ D_PTS, C_PTS+D_PTS ≤ NUMPOINTS−3
     * 
     * @param points The set of points
     * @param params The parameters
     * @return true, if the condition is met, false otherwise
     */
    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        int n = points.length;

        // Requirement: NUMPOINTS < 5 -> return false
        if (n < 5) { return false; }

        int cPts = params.getC_PTS();
        int dPts = params.getD_PTS();
        double epsilon = params.getEPSILON();

        // Defensive check
        if (cPts < 1 || dPts < 1) {
            throw new IllegalArgumentException("C_PTS and D_PTS must be at least 1.");
        }

        // Iterate through all valid triples of points
        for (int i = 0; i + cPts + dPts + 2 < n; i++) {
            Point a = points[i];
            Point b = points[i + cPts + 1]; // Vertex point
            Point c = points[i + cPts + dPts + 2];

            // Undefined angle check
            if ((a.x() == b.x() && a.y() == b.y()) || (c.x() == b.x() && c.y() == b.y())) {
                continue;
            }

            double angle;

            // Calculate the angle at point B formed by points A and C
            try {
                angle = MathHelp.angleRadians(
                    a.x(), a.y(), 
                    b.x(), b.y(), 
                    c.x(), c.y()
                );
            } catch (IllegalArgumentException e) {
                // Angle undefined due to zero-length vector
                continue;
            }

            // Check angle condition against pi +- epsilon
            if (angle < Math.PI - epsilon || angle > Math.PI + epsilon) {
                return true;
            }
        }
        return false;
    }
}