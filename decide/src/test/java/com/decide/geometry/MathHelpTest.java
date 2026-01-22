package com.decide.geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        assertEquals(MathHelp.calculateDistance(p1, p2), Math.sqrt(2));
    }

    @Test
    void testNegativePoints() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-1, 1);
        assertEquals(MathHelp.calculateDistance(p1, p2), Math.sqrt(2));
    }

    @Test
    void testDistanceBetween10and20is10() {
        Point p1 = new Point(10, 0);
        Point p2 = new Point(20, 0);
        assertEquals(MathHelp.calculateDistance(p1, p2), 10);
    }

    /*
    ------------------- Tests for the calculate smallest radius function ---------------
    */
    @Test
    void threeIdenticalPointsReturn0() {
        Point p1 = new Point(123.2, 145.2);
        Point p2 = new Point(123.2, 145.2);
        Point p3 = new Point(123.2, 145.2);
        assertEquals(MathHelp.calculateSmallestRadius(p1, p2, p3), 0);
    }

    @Test
    void collinearPointsReturnHalfOfLargestSide() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(-1, -2);
        Point p3 = new Point(0,0);
        assertEquals(MathHelp.calculateSmallestRadius(p1, p2, p3), 2.5); 
    }

    @Test
    void obtuseTriangleReturnsHalfOfLargestSide() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 8);
        Point p3 = new Point(-2, 2);
        assertEquals(MathHelp.calculateSmallestRadius(p1, p2, p3), 4);
    }

    @Test
    void acuteTriangleReturnsTheCircumRadius () {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 8);
        Point p3 = new Point(-2, 2);
        // the result is supposed to be 6.0827625302982
        // do boleans due to working with doubles (introduce epsilon/threshold)
        double epsilon = 0.001;
        assertTrue(MathHelp.calculateSmallestRadius(p1, p2, p3)-epsilon < 6.0827625302982);
        assertTrue(MathHelp.calculateSmallestRadius(p1, p2, p3) + epsilon > 6.0827625302982);
    }
}