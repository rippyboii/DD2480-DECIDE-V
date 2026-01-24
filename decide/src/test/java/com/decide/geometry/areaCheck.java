package com.decide.geometry;

import com.decide.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class areaCheck {

    @Test
    void returnsHalfForRightTriangle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0, 1);

        double area = MathHelp.triangleArea(p1, p2, p3);
        assertEquals(0.5, area, 1e-9);
    }

    @Test
    void collinearPointsReturnZero() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(2, 0);

        double area = MathHelp.triangleArea(p1, p2, p3);
        assertEquals(0.0, area, 1e-9);
    }

    @Test
    void pointOrderDoesNotChangeArea() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0, 1);

        double area1 = MathHelp.triangleArea(p1, p2, p3);
        double area2 = MathHelp.triangleArea(p2, p3, p1);

        assertEquals(area1, area2, 1e-9);
    }
}
