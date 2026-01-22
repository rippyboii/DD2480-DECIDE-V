package com.decide.geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.decide.model.Point;

public class MathHelpTest {
    
    /*
    ------------------- Tests for the calculate distance function ---------------
    */
    @Test
    void testDistance11IsSqrt2() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        assertEquals(Math.sqrt(2), MathHelp.calculateDistance(p1, p2));
    }

    @Test
    void testNegativePoints() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-1, 1);
        assertEquals(Math.sqrt(2), MathHelp.calculateDistance(p1, p2));
    }

    @Test
    void testDistanceBetween10and20is10() {
        Point p1 = new Point(10, 0);
        Point p2 = new Point(20, 0);
        assertEquals(10, MathHelp.calculateDistance(p1, p2));
    }

    /*
    ------------------- Tests for the calculate smallest radius function ---------------
    */
    @Test
    void threeIdenticalPointsReturn0() {
        Point p1 = new Point(123.2, 145.2);
        Point p2 = new Point(123.2, 145.2);
        Point p3 = new Point(123.2, 145.2);
        assertEquals(0, MathHelp.calculateSmallestRadius(p1, p2, p3),1e-10);
    }

    @Test
    void collinearPointsReturnHalfOfLargestSide() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(-1, -2);
        Point p3 = new Point(0,0);
        assertEquals(Math.sqrt(5), MathHelp.calculateSmallestRadius(p1, p2, p3),1e-10); 
    }

    @Test
    void obtuseTriangleReturnsHalfOfLargestSide() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 8);
        Point p3 = new Point(-2, 2);
        assertEquals(4, MathHelp.calculateSmallestRadius(p1, p2, p3),1e-10);
    }

    @Test
    void acuteTriangleReturnsTheCircumRadius () {
        Point p1 = new Point(-5, -1);
        Point p2 = new Point(7, -1);
        Point p3 = new Point(0, 6);
        // the result is supposed to be 6.0827625302982
        // do boleans due to working with doubles (introduce epsilon/threshold)
        assertEquals(6.0827625302982, MathHelp.calculateSmallestRadius(p1, p2, p3), 1e-10);
    }

    // ------------------- Tests for circumcenter function ----------------
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