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
}