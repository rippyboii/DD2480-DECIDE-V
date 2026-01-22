package com.decide.model;

import java.util.List;

public class DecideInput {
    public Parameters parameters;
    public List<Point> points;
    public boolean[] puv;
    public Connector[][] lcm;

    // Constants
    private static final int MAX_POINTS = 100;
    private static final int MIN_POINTS = 2;
    private static final int LIC_COUNT = 15;

    /**
     * Constructor for DecideInput
     * @param params Parameters of program
     * @param points List of Points
     * @param puv Vector of booleans representing PUV
     * @param lcm Matrix of Connectors
     * 
     * @throws IllegalArgumentException if number of points is not between MIN_POINTS and MAX_POINTS
     */
    public DecideInput(Parameters params, List<Point> points, boolean[] puv, Connector[][] lcm) {
        // Validate number of points
        if (points.size() > MAX_POINTS || points.size() < MIN_POINTS) {
            throw new IllegalArgumentException("Number of points must be between " + MIN_POINTS + " and " + MAX_POINTS);
        }

        // Validate PUV length
        if (puv.length != LIC_COUNT) {
            throw new IllegalArgumentException("PUV length must be " + LIC_COUNT);
        }

        // Validate LCM dimensions
        if (lcm.length != LIC_COUNT || lcm[0].length != LIC_COUNT) {
            throw new IllegalArgumentException("LCM must be a " + LIC_COUNT + "x" + LIC_COUNT + " matrix");
        }

        // Validate LCM symmetry
        if (!isSymmetric(lcm)) {
            throw new IllegalArgumentException("LCM must be symmetric");
        }

        // Assign values
        this.parameters = params;
        this.points = points;
        this.puv = puv;
        this.lcm = lcm;
    }

    /**
     * Get the number of points
     * @return Number of points
     */
    public int getNumPoints() {
        return this.points.size();
    }


    /**
     * Helper method to check if a LCM matrix is symmetric
     * @param matrix LCM Matrix to check
     * @return true if symmetric, false otherwise
     */
    private boolean isSymmetric(Connector[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check for square matrix
        if (rows != cols) { return false; }

        // Check symmetry
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}