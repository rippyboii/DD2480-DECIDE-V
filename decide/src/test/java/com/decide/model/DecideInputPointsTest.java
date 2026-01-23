package com.decide.model;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class DecideInputPointsTest extends DecideInputTest {
    /**
     * Contract:
     * The DecideInput constructor should allow 2 points, which is the minimum 
     * valid number of points.
     *
     * Expected Behavior:
     * When provided with exactly 2 points, the constructor shall successfully 
     * create a DecideInput instance.
     */
    @Test
    public void testValidWith2Points() {
        // Generate 2 points
        ArrayList<Point> points = this.generatePoints(LOWER_VALID);
        DecideInput input = new DecideInput(params, points, puv_valid, lcm_valid);

        // Assert
        assertEquals(LOWER_VALID, input.getNumPoints());
    }

    /**
     * Contract:
     * The DecideInput constructor should NOT allow 1 point, which is below the minimum 
     * valid number of points.
     *
     * Expected Behavior:
     * When provided with exactly 1 point, the constructor shall throw an IllegalArgumentException.
     */
    @Test
    public void testInvalidWith1Point() {
        // Generate 1 point
        ArrayList<Point> points = generatePoints(LOWER_INVALID);
        
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points, puv_valid, lcm_valid);
        });
    }

    /**
     * Contract:
     * The DecideInput constructor should allow 100 points, which is the maximum 
     * valid number of points.
     *
     * Expected Behavior:
     * When provided with exactly 100 points, the constructor shall successfully 
     * create a DecideInput instance.
     */
    @Test
    public void testValidWith100Points() {
        // Create a list with 100 points
        ArrayList<Point> points = this.generatePoints(UPPER_VALID);

        DecideInput input = new DecideInput(params, points, puv_valid, lcm_valid);

        // Assert
        assertEquals(UPPER_VALID, input.getNumPoints());
    }

    /**
     * Contract:
     * The DecideInput constructor should NOT allow 101 points, which is above the maximum 
     * valid number of points.
     *
     * Expected Behavior:
     * When provided with exactly 101 points, the constructor shall throw an IllegalArgumentException.
     */
    @Test
    public void testInvalidWith101Points() {
        // Create a list with 101 points
        ArrayList<Point> points = this.generatePoints(UPPER_INVALID);
        
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points, puv_valid, lcm_valid);
        });
    }

}