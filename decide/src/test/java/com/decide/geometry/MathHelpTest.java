package com.decide.geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.decide.model.Point;

public class MathHelpTest {
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
}