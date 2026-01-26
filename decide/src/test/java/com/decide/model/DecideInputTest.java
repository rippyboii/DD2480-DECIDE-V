package com.decide.model;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;

public abstract class DecideInputTest {

    protected Parameters params;
    protected ArrayList<Point> points_valid;
    protected boolean[] puv_valid;
    protected Connector[][] lcm_valid;

    /* #region Constants */

    // Minimum 2 points
    protected final static int LOWER_VALID = 2;
    protected final static int LOWER_INVALID = 1;

    // Maximum 100 points
    protected final static int UPPER_VALID = 100;
    protected final static int UPPER_INVALID = 101;

    protected final static int LIC_COUNT = 15;
    /* #endregion */

    @BeforeEach
    public void setup() {
        this.params = new Parameters();
        this.points_valid = generatePoints(UPPER_VALID);
        this.puv_valid = generatePUV(LIC_COUNT);
        this.lcm_valid = generateLCM(LIC_COUNT);
    }


    /**
     * Helper method to generate a list of points
     * @param numPoints Number of points to generate
     * @return List of generated points
     */
    protected ArrayList<Point> generatePoints(int numPoints) {
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
    protected boolean[] generatePUV(int length) {
        Random rand = new Random();
        boolean[] puv = new boolean[length];
        for (int i = 0; i < length; i++) {
            puv[i] = rand.nextBoolean();
        }
        return puv;
    }

    /**
     * Helper method to generate a random LCM matrix
     * @param rows Number of rows
     * @param cols Number of columns
     * @return Generated LCM matrix
     */
    protected Connector[][] generateLCM(int size) {
        Random rand = new Random();
        Connector[][] lcm = new Connector[size][size];
        Connector[] connectors = Connector.values();

        // Populate LCM with random connectors
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                lcm[i][j] = connectors[rand.nextInt(connectors.length)];
                lcm[j][i] = lcm[i][j]; // Symmetry
            }
        }
        return lcm;
    }


    
}
