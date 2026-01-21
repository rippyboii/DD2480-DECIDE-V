package com.decide.geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class angle_checkTest {

    @Test
    void testRightAngle() {
        // A(1,0), B(0,0), C(0,1) => 90 degrees at B
        double angle = angle_check.angleRadians(1, 0, 0, 0, 0, 1);
        assertEquals(Math.PI / 2.0, angle, 1e-12);
    }

    @Test
    void testStraightAngle() {
        // A(-1,0), B(0,0), C(1,0) => 180 degrees at B
        double angle = angle_check.angleRadians(-1, 0, 0, 0, 1, 0);
        assertEquals(Math.PI, angle, 1e-12);
    }

    @Test
    void testZeroAngle() {
        // A(1,0), B(0,0), C(2,0) => 0 degrees at B (collinear, same direction)
        double angle = angle_check.angleRadians(1, 0, 0, 0, 2, 0);
        assertEquals(0.0, angle, 1e-12);
    }

    @Test
    void test45DegreeAngle() {
        // A(1,0), B(0,0), C(1,1) => 45 degrees at B
        double angle = angle_check.angleRadians(1, 0, 0, 0, 1, 1);
        assertEquals(Math.PI / 4.0, angle, 1e-12);
    }

    @Test
    void testObtuseAngle() {
        // A(1,0), B(0,0), C(-1,1) => 135 degrees at B
        double angle = angle_check.angleRadians(1, 0, 0, 0, -1, 1);
        assertEquals(3.0 * Math.PI / 4.0, angle, 1e-12);
    }

    @Test
    void testThrowsWhenPointAEqualsB() {
        // A == B makes BA vector length 0
        assertThrows(IllegalArgumentException.class,
                () -> angle_check.angleRadians(0, 0, 0, 0, 1, 1));
    }

    @Test
    void testThrowsWhenPointCEqualsB() {
        // C == B makes BC vector length 0
        assertThrows(IllegalArgumentException.class,
                () -> angle_check.angleRadians(1, 1, 0, 0, 0, 0));
    }

    @Test
    void testThrowsWhenAllPointsAreSame() {
        // All points the same => both vectors have zero length
        assertThrows(IllegalArgumentException.class,
                () -> angle_check.angleRadians(5, 5, 5, 5, 5, 5));
    }

    @Test
    void testAngleWithNegativeCoordinates() {
        // A(-2,-2), B(0,0), C(-2,2) => 90 degrees at B
        double angle = angle_check.angleRadians(-2, -2, 0, 0, -2, 2);
        assertEquals(Math.PI / 2.0, angle, 1e-12);
    }
}
