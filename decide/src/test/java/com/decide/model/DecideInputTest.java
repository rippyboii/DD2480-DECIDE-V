package com.decide.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.decide.model.*;

public class DecideInputTest {

    private Parameters params;
    private boolean[] puv;
    private Connector[][] lcm;

    /* #region Constants */

    // Minimum 2 points
    private final static int LOWER_VALID = 2;
    private final static int LOWER_INVALID = 1;

    // Maximum 100 points
    private final static int UPPER_VALID = 100;
    private final static int UPPER_INVALID = 101;

    private final static int LIC_COUNT = 15;
    /* #endregion */

    @BeforeEach
    public void setup() {
        this.params = new Parameters();
        this.puv = new boolean[]{true, false};
        this.lcm = new Connector[][]{
            {Connector.AND, Connector.OR},
            {Connector.NOT_USED, Connector.AND}
        };
    }

    @Test
    public void testValidWith2Points() {
        // Generate 2 points
        ArrayList<Point> points = this.generatePoints(LOWER_VALID);

        Parameters params = new Parameters();
        boolean[] puv = this.generatePUV(LIC_COUNT);
        Connector[][] lcm = new Connector[][]{
            {Connector.AND, Connector.OR},
            {Connector.NOT_USED, Connector.AND}
        };
        
        DecideInput input = new DecideInput(params, points, puv, lcm);

        // Assert
        assertEquals(LOWER_VALID, input.getNumPoints());
    }

    @Test
    public void testInvalidWith1Point() {
        // Generate 1 point
        ArrayList<Point> points = generatePoints(LOWER_INVALID);

        Parameters params = new Parameters();
        boolean[] puv = this.generatePUV(LIC_COUNT);
        Connector[][] lcm = new Connector[][]{
            {Connector.AND}
        };
        
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points, puv, lcm);
        });
    }

    @Test
    public void testValidWith100Points() {
        // Create a list with 100 points
        ArrayList<Point> points = this.generatePoints(UPPER_VALID);

        Parameters params = new Parameters();
        boolean[] puv = this.generatePUV(LIC_COUNT);
        Connector[][] lcm = new Connector[][]{
            {Connector.AND, Connector.OR},
            {Connector.NOT_USED, Connector.AND}
        };
        
        DecideInput input = new DecideInput(params, points, puv, lcm);

        // Assert
        assertEquals(UPPER_VALID, input.getNumPoints());
    }

    @Test
    public void testInvalidWith101Points() {
        // Create a list with 101 points
        ArrayList<Point> points = this.generatePoints(UPPER_INVALID);

        Parameters params = new Parameters();
        boolean[] puv = this.generatePUV(LIC_COUNT);
        Connector[][] lcm = new Connector[][]{
            {Connector.AND, Connector.OR},
            {Connector.NOT_USED, Connector.AND}
        };
        
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points, puv, lcm);
        });
    }


    @Test
    public void testInvalidPUMSize() {
        // Create a list with valid number of points
        ArrayList<Point> points = this.generatePoints(UPPER_VALID);

        Parameters params = new Parameters();
        boolean[] puv1 = this.generatePUV(LIC_COUNT - 1); // Invalid size
        boolean[] puv2 = this.generatePUV(LIC_COUNT + 1); // Invalid size

        Connector[][] lcm = new Connector[][]{
            {Connector.AND, Connector.OR},
            {Connector.NOT_USED, Connector.AND}
        };

        
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points, puv1, lcm);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points, puv2, lcm);
        });
    }


    /**
     * Helper method to generate a list of points
     * @param numPoints Number of points to generate
     * @return List of generated points
     */
    private ArrayList<Point> generatePoints(int numPoints) {
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < numPoints; i++) {
            points.add(new Point(i * 1.0, i * 2.0));
        }
        return points;
    }

    /**
     * Helper method to generate a random PUV array
     * @param length Length of the PUV array
     * @return Generated PUV array
     */
    private boolean[] generatePUV(int length) {
        Random rand = new Random();
        boolean[] puv = new boolean[length];
        for (int i = 0; i < length; i++) {
            puv[i] = rand.nextBoolean();
        }
        return puv;
    }


    
}
