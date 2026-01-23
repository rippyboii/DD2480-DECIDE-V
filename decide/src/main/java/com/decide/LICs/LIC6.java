package com.decide.LICs;

import com.decide.geometry.MathHelp;
import com.decide.model.Point;
import com.decide.model.Parameters;


public class LIC6 {

    public static boolean evaluate(Point[] points, Parameters params) {

        int n = points.length;
        int N_PTS = params.N_PTS;
        double DIST = params.DIST;

        if (n < N_PTS) {
            return false;
        }

        for (int i = 0; i <= n - N_PTS; i++) {
            Point A = points[i];
            Point B = points[i + N_PTS - 1];

            for (int j = i + 1; j < i + N_PTS - 1; j++) {
                double d = MathHelp.pointToLineDistance(A, B, points[j]);
                if (d > DIST) {
                    return true;
                }
            }
        }

        return false;
    }
}
