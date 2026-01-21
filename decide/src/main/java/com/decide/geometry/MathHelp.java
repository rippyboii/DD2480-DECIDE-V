package com.decide.geometry;

import com.decide.model.Point;

public class MathHelp {
    /**
     * Calculates the distance between two points.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance between the two points
     */
    public static double calculateDistance(Point p1, Point p2) {
        double distance = Math.pow(Math.pow(p1.x() - p2.x(), 2) + Math.pow(p1.y() - p2.y(),2),0.5);
        return distance;
    }

    /**
     * Calculates the area of a triangle formed by three points.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @return the area of triangle formed by p1,p2,p3
     */
    public static double triangleArea(Point p1, Point p2, Point p3) {
    return 0.5 * Math.abs(
            p1.x() * (p2.y() - p3.y())
          + p2.x() * (p3.y() - p1.y())
          + p3.x() * (p1.y() - p2.y())
    );
}

}

