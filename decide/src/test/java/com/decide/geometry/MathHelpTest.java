package com.decide.geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.decide.model.Point;

public class MathHelpTest {
    
    /*
    ------------------- Tests for the calculate distance function ---------------
    */
    /**
     * Contract:
     * The calculate distance function should calculate the Euclidean distance between two given points.
     *
     * Expected Behavior:
     * For points (0,0) and (1,1), the distance should be sqrt(2)
    */
    @Test
    void testDistance11IsSqrt2() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        assertEquals(Math.sqrt(2), MathHelp.calculateDistance(p1, p2));
    }

    /**
     * Contract:
     * The calculate distance function should calculate the Euclidean distance between two given points.
     *
     * Expected Behavior:
     * For points (0,0) and (-1,1), the distance should be also sqrt(2) (tests for negative numbers)
    */
    @Test
    void testNegativePoints() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-1, 1);
        assertEquals(Math.sqrt(2), MathHelp.calculateDistance(p1, p2));
    }

    /*
    ------------------- Tests for the calculate smallest radius function ---------------
    */

    /**
     * Contract:
     * The calculateSmallestRadius function should return 0 for identical points
     *
     * Expected Behavior:
     * When provided with 3 identical points (in this case (123.2, 145.2)), the resulting radius
     * should be equal to 0.
    */
    @Test
    void threeIdenticalPointsReturn0() {
        Point p1 = new Point(123.2, 145.2);
        Point p2 = new Point(123.2, 145.2);
        Point p3 = new Point(123.2, 145.2);
        assertEquals(0, MathHelp.calculateSmallestRadius(p1, p2, p3),1e-10);
    }

    /**
     * Contract:
     * The calculateSmallestRadius function should return half of the maximum distance between the given points.
     *
     * Expected Behavior:
     * When provided with collinear points (1,2), (-1,-2), and (0.5, 1), the function should return sqrt(5).
    */
    @Test
    void collinearPointsReturnHalfOfLargestDistance() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(-1, -2);
        Point p3 = new Point(0.5,1);
        assertEquals(Math.sqrt(5), MathHelp.calculateSmallestRadius(p1, p2, p3),1e-10); 
    }

    /**
     * Contract:
     * The calculateSmallestRadius function should return half of the largest side, if the 3 supplied points form an obtuse triangle.
     *
     * Expected Behavior:
     * When provided with points (0,0), (0,8), and (-2,2), which form an obtuse triangle,
     * the function should return 4, which is half of the longest side, in this case side connecting (0,0) and (0,8)
    */
    @Test
    void obtuseTriangleReturnsHalfOfLargestSide() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 8);
        Point p3 = new Point(-2, 2);
        assertEquals(4, MathHelp.calculateSmallestRadius(p1, p2, p3),1e-10);
    }

    /**
     * Contract:
     * The calculateSmallestRadius function should return the circumradius, if the 3 supplied point form an acute triangle.
     *
     * Expected Behavior:
     * When provided with points (-5,-1), (7,1), and (0,6), which form an acute triangle,
     * the function should return 6.0827625302982, which is the circumradius of the formed triangle.
    */
    @Test
    void acuteTriangleReturnsTheCircumRadius () {
        Point p1 = new Point(-5, -1);
        Point p2 = new Point(7, -1);
        Point p3 = new Point(0, 6);
        // the result is supposed to be 6.0827625302982
        // do boleans due to working with doubles (introduce epsilon/threshold)
        assertEquals(6.0827625302982, MathHelp.calculateSmallestRadius(p1, p2, p3), 1e-10);
    }
    /**
     * Contract:
     * The calculateSmallestRadius function should return the circumradius, if the 3 supplied point form an acute triangle.
     *
     * Expected Behavior:
     * For good measure, test the same behavior for different set of points.
     * When provided with points (8,-2), (6,10), and (-8,6), which form an acute triangle,
     * the function should return 9.0018363599457, which is the circumradius of the formed triangle.
    */
    @Test
    void acuteTriangleReturnsTheCircumRadius2 () {
        Point p1 = new Point(8, -2);
        Point p2 = new Point(6, 10);
        Point p3 = new Point(-8, 6);
        // the result is supposed to be 6.0827625302982
        // do boleans due to working with doubles (introduce epsilon/threshold)
        assertEquals(9.0018363599457, MathHelp.calculateSmallestRadius(p1, p2, p3), 1e-10);
    }

    // ------------------- Tests for circumcenter function ----------------
    /**
     * Contract:
     * The calculateCircumcenter function should throw an IllegalArgumentException when supplied with collinear points.
     *
     * Expected Behavior:
     * Given points (-5,1), (0,0) and (5,-1), the function shall return IllegalArgumentException.
    */
    @Test
    void collinearPointsThrowExceptionForCircumcenter() {
        Point p1 = new Point(-5, 1);
        Point p2 = new Point(-1, 0.2);
        Point p3 = new Point(5, -1);

        assertThrows(IllegalArgumentException.class,
            () -> {
                MathHelp.calculateCircumcenter(p1, p2, p3);
            }
        );
    }
    /**
     * Contract:
     * The calculateCircumcenter function should return the circumcenter of the triangle constructed from the 3 supplied points.
     *
     * Expected Behavior:
     * Given points (-5,-1), (7,-1) and (0,6), the function shall return circumcenter (1,0).
    */
    @Test
    void testCircumcenterCalculation() {
        Point p1 = new Point(-5, -1);
        Point p2 = new Point(7, -1);
        Point p3 = new Point(0, 6);
        Point center = MathHelp.calculateCircumcenter(p1, p2, p3);
        assertEquals(1, center.x(),1e-10);
        assertEquals(0, center.y(),1e-10);
    }



    // ------------------- Tests for cross product function ---------------
    /**
     * Contract:
     * The calculateCrossProduct function should throw IllegalArgumentException when supplied with vectors of different size than 3.
     *
     * Expected Behavior:
     * Given that the first vector if of size 2, the function shall throw IllegalArgumentException.
    */
    @Test
    void crossProductThrowsException () {
        double[] v1 = {0.1, 2.0};
        double[] v2 = {0.3, -2.4, 3.0};
        assertThrows(IllegalArgumentException.class,
            () -> {
                MathHelp.calculateCrossProduct(v1, v2);
            }
        );
    }
    /**
     * Contract:
     * The calculateCrossProduct function should correctly calculate the cross product between 2 3D vectors.
     *
     * Expected Behavior:
     * Given two vectors v1 = (0.1, 2.0, 4.2) and v2 = (0.3,-2.4, 3.0), the result of the cross product should be 
     * (16.08, 0.96. -0.84).
    */
    @Test
    void crossProductReturnsValidResult () {
        double[] v1 = {0.1, 2.0, 4.2};
        double[] v2 = {0.3, -2.4, 3.0};
        double[] result = MathHelp.calculateCrossProduct(v1, v2);
        assertEquals(result[0], 16.08, 0.00001);
        assertEquals(result[1], 0.96,  0.00001);
        assertEquals(result[2], -0.84, 0.00001);
    }
}