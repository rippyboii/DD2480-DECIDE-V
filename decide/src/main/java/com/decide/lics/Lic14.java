package com.decide.lics;

import com.decide.geometry.MathHelp;
import com.decide.model.Parameters;
import com.decide.model.Point;

public final class Lic14 implements Lic {
    @Override
    public boolean evaluate(Point[] points, Parameters params) {
        int n = points.length;

        // Requirement: NUMPOINTS < 5 -> return false
        if (n < 5) { return false; }

        int ePts = params.E_PTS;
        int fPts = params.F_PTS;
        double area1 = params.AREA1;
        double area2 = params.AREA2;

        boolean condition1Satisfied = false;
        boolean condition2Satisfied = false;

        // Defensive checks
        if (ePts < 1 || fPts < 1) {
            throw new IllegalArgumentException("E_PTS and F_PTS must be at least 1.");
        }

        if (area1 < 0 || area2 < 0) {
            throw new IllegalArgumentException("AREA1 and AREA2 must be non-negative.");
        }

        if (ePts + fPts > n - 3) {
            return false; // Not enough points to form required triples
        }

        // Iterate through all valid triples of points
        for (int i = 0; i + ePts + fPts + 2 < n; i++) {
            Point a = points[i];
            Point b = points[i + ePts + 1]; // Vertex point
            Point c = points[i + ePts + fPts + 2];

            // Calculate area of triangle formed by points a, b, c
            double area = MathHelp.triangleArea(a, b, c);

            // Condition 1: Area strictly greater than AREA1
            if (area > area1) {
                condition1Satisfied = true;
            }

            // Condition 2: Area strictly less than AREA2
            if (area < area2) {
                condition2Satisfied = true;
            }

            // If both conditions are satisfied, return true
            if (condition1Satisfied && condition2Satisfied) {
                return true;
            }
        }

        // If all triples checked and conditions not met, return false
        return false;
    }
}