package com.decide.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class DecideInputLCMTest extends DecideInputTest {
    
    /**
     * Contract:
     * The DecideInput constructor should accept a valid LCM matrix of size 15x15,
     * which is the required size for the LCM.
     *
     * Expected Behavior:
     * When provided with a valid LCM matrix of size 15x15, the constructor shall 
     * successfully create a DecideInput instance.
     */
    @Test
    public void testValidLCMSize() {
        DecideInput input = new DecideInput(params, points_valid, puv_valid, lcm_valid);

        // Assert valid size
        assertEquals(LIC_COUNT, input.lcm.length);
        assertEquals(LIC_COUNT, input.lcm[0].length);
    }

    /**
     * Contract:
     * The DecideInput constructor should NOT accept an invalid LCM matrix size,
     * which is not 15x15.
     *
     * Expected Behavior:
     * When provided with an LCM matrix size other than 15x15, the constructor shall 
     * throw an IllegalArgumentException.
     */
    @Test
    public void testInvalidLCMSize() {
        // Off by one sizes
        Connector[][] lcm1 = this.generateLCM(LIC_COUNT - 1);
        Connector[][] lcm2 = this.generateLCM(LIC_COUNT + 1);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points_valid, puv_valid, lcm1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points_valid, puv_valid, lcm2);
        });
    }

    /**
     * Contract:
     * The DecideInput constructor should NOT accept an LCM matrix that is not symmetric.
     *
     * Expected Behavior:
     * When provided with a non-symmetric LCM matrix, the constructor shall throw an 
     * IllegalArgumentException.
     */
    @Test
    public void testInvalidLCMSymmetry() {
        // Generate a valid LCM
        Connector[][] lcm_invalid = this.generateLCM(LIC_COUNT);

        // Break symmetry
        lcm_invalid[0][1] = Connector.AND;
        lcm_invalid[1][0] = Connector.OR;

        // Assert symmetry
        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points_valid, puv_valid, lcm_invalid);
        });
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