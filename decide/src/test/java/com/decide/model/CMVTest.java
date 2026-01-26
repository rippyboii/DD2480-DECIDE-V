package com.decide.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CMVTest {
    /**
     * Generates a specified number of test points
     * @param numPoints The number of points to be specified
     * @return Returns a sample of testing points
     */
    private Point[] generatePoints(int numPoints) {
        Point[] points = new Point[numPoints];
        for (int i = 0; i < numPoints; i++) {
            points[i] = new Point(1.0*i, 2.0*i);
        }
        return points;
    }

    /**
     * Generates sample parameters.
     * @return the parameters
     */
    private Parameters sampleParameters() {
        Parameters params = new Parameters();
        params.LENGTH1= 1;
        params.RADIUS1= 3;
        params.EPSILON = 10e-5;
        params.AREA1 = 3.5;
        params.Q_PTS = 5;
        params.QUADS = 2;
        params.DIST = 8;
        params.N_PTS = 3;
        params.K_PTS = 3;
        params.A_PTS = 1;
        params.B_PTS = 1;
        params.C_PTS = 1;
        params.D_PTS = 1;
        params.E_PTS = 1;
        params.F_PTS = 1;
        params.G_PTS = 2;
        params.LENGTH2= 2;
        params.RADIUS2= 1.5;
        params.AREA2 = 2.3;
        return params;
    }


    /**
     * Contract:
     * The CMV's evaluate method should return a boolean array of length 15,
     * where the value at index i corresponds to the result of i-th LIC.
     * 
     * Expected behavior:
     * The length of the resulting boolean array should be 15, and everything should execute correctly.
     */
    @Test
    void testEvaluation() {
        Point[] points = generatePoints(10);
        CMV cmv = new CMV();
        Parameters params = sampleParameters();
        boolean[] result = cmv.evaluate(points, params);
        assertNotNull(result);
        assertTrue(result.length == 15);
    } 
}
