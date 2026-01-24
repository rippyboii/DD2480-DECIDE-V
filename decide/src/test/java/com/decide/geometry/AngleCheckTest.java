package com.decide.geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AngleCheckTest {

    @Test
    void testAngle() {
        // A(1,0), B(0,0), C(0,1) -> 90 degrees at B
        double angle = MathHelp.angleRadians(1, 0, 0, 0, 0, 1);
        assertEquals(Math.PI / 2.0, angle, 1e-12);  // π/2, not π
        System.out.println("Angle ABC: " + angle);
    }

}
