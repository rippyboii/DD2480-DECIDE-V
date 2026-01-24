package com.decide.LICs;

import com.decide.geometry.AngleCheck;
import com.decide.model.Point;
import com.decide.model.Parameters;

public class LIC9 implements LIC {


    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        int n = points.length;

        // Requirement: NUMPOINTS < 5 -> return false
        if (n < 5) { return false; }

        int cPts = params.C_PTS;
        int dPts = params.D_PTS;
        double epsilon = params.EPSILON;

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
                angle = AngleCheck.angleRadians(
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