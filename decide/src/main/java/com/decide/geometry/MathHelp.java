package com.decide.geometry;

import com.decide.model.Point;

public class MathHelp {
    // Prevent instantiation (utility class)
    private MathHelp(){} 

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

    /**
     * Calculates the smallest radius needed to enclose 3 points inside a circle.
     * 
     * Given 3 planar points, calculate the smallest radius of a circle which encloses all the points, i.e.
     * the points are located inside or on the circle.
     * If the 3 points are identical, then the radius is equal to 0.
     * If the 3 points are collinear or form an obtuse triangle, the radius is equal to the half of the longest side.
     * If the 3 points form an acute triangle, the radius is equal to the circumradius.
     * 
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @return the smallest radius of enclosing circle
     */
    public static double calculateSmallestRadius(Point p1, Point p2, Point p3) {
        // calculate the vectors from points
        double[] v1 = {p1.x() - p2.x(), p1.y() - p1.y()};
        double[] v2 = {p2.x() - p3.x(), p2.y() - p3.y()};
        // check if the points are identical
        if (v1[0] == 0 && v1[1] == 0 && v2[0] == 0 && v2[1] == 0) {
            return 0.0;
        }
        double d1 = calculateDistance(p1, p2);
        double d2 = calculateDistance(p2, p3);
        double d3 = calculateDistance(p3, p1);
        double max_d = Math.max(d1, Math.max(d2, d3));
        // check if the points are collinear (2D cross product)
        if (v1[0] * v2[1] - v1[1]*v2[0] == 0) {
            
            return max_d / 2.0;
        }
        // check if the triangle is obtuse or acute

        double angle1 = angle_check.angleRadians(p1.x(),p1.y(),p2.x(),p2.y(),p3.x(),p3.y());
        double angle2 = angle_check.angleRadians(p3.x(),p3.y(),p1.x(),p1.y(),p2.x(),p2.y());
        double angle3 = angle_check.angleRadians(p2.x(),p2.y(),p3.x(),p3.y(),p1.x(),p1.y());

        if (Math.abs(angle1) > Math.PI/2 || Math.abs(angle2) > Math.PI/2 || Math.abs(angle3) > Math.PI/2) {
            return max_d / 2.0;
        }

        // now the triangle is acute -> the radius is the circumradius
        return 0;
    }

    public static Point calculateCircumcenter(Point p1, Point p2, Point p3) {
        Point result = new Point(1,1);
        return result;
    }

    /**
     * Calculates the cross product between 2 3D vectors.
     * @param a the first vector
     * @param b the second vector
     * @return the cross product
     */
    public static double[] calculateCrossProduct(double[] a, double[] b) {
        if (a.length != 3 || b.length != 3) {
            throw new IllegalArgumentException("Both vectors must be 3D!");
        }
        double[] result = { a[1]*b[2] - a[2]*b[1],
                            a[2]*b[0] - a[0]*b[2],
                            a[0]*b[1] - a[1]*b[0]
        };
        return result;
    }

}

