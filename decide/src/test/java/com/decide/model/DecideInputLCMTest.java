package com.decide.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class DecideInputLCMTest extends DecideInputTest {
    
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


    @Test
    public void testValidLCMSymmetry() {
        // Assert symmetry
        assertEquals(true, isSymmetric(lcm_valid));
    }

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