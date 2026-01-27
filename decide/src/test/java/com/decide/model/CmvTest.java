package com.decide.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CmvTest {
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
        params.setLENGTH1(1);
        params.setRADIUS1(3);
        params.setEPSILON(10e-5);
        params.setAREA1(3.5);
        params.setQ_PTS(5);
        params.setQUADS(2);
        params.setDIST(8);
        params.setN_PTS(3);
        params.setK_PTS(3);
        params.setA_PTS(1);
        params.setB_PTS(1);
        params.setC_PTS(1);
        params.setD_PTS(1);
        params.setE_PTS(1);
        params.setF_PTS(1);
        params.setG_PTS(2);
        params.setLENGTH2(2);
        params.setRADIUS2(1.5);
        params.setAREA2(2.3);
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
        Cmv cmv = new Cmv();
        Parameters params = sampleParameters();
        boolean[] result = cmv.evaluate(points, params);
        assertNotNull(result);
        assertTrue(result.length == 15);
    } 
}
