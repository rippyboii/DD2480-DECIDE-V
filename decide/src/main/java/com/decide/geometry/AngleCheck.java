package com.decide.geometry;


public final class AngleCheck {

    // Prevent instantiation (utility class)
    private AngleCheck() {}

    public static double angleRadians(
            double ax, double ay,
            double bx, double by,
            double cx, double cy
    ) {
        // Vectors BA and BC (from vertex B to A/C)
        double v1x = ax - bx;
        double v1y = ay - by;
        double v2x = cx - bx;
        double v2y = cy - by;
        
        double norm1 = Math.hypot(v1x, v1y);
        double norm2 = Math.hypot(v2x, v2y);

        // if the lenght of the vectors are 0, then undefined angle
        if (norm1 == 0.0 || norm2 == 0.0) {
            throw new IllegalArgumentException("Angle undefined: well well, you have a vector with zero length!");
        }

        // using dot product to get the cos of the angle
        double dot = v1x * v2x + v1y * v2y;
        double cos = dot / (norm1 * norm2);

        return Math.acos(cos); // [0, π]
    }
}
