package com.decide.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class DecideInputPUVTest extends DecideInputTest {
    
    /**
     * Contract:
     * The DecideInput constructor should accept a PUV array of length 15.
     *
     * Expected Behavior:
     * When provided with a PUV array of length 15, the constructor shall successfully 
     * create a DecideInput instance without throwing any exceptions.
     */
    @Test
    public void testValidPUVSize() {
        boolean[] puv = generatePUV(LIC_COUNT); // Valid size
        
        assertDoesNotThrow(() -> {
            new DecideInput(params, points_valid, puv, lcm_valid);
        });
    }
    
    /**
     * Contract:
     * The DecideInput constructor should NOT accept a PUV array that does not have
     * the required length of 15.
     *
     * Expected Behavior:
     * When provided with a PUV array of length other than 15, the constructor shall 
     * throw an IllegalArgumentException.
     */
    @Test
    public void testInvalidPUVSize() {
        boolean[] puv1 = generatePUV(LIC_COUNT - 1); // Invalid size
        boolean[] puv2 = generatePUV(LIC_COUNT + 1); // Invalid size
        
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points_valid, puv1, lcm_valid);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new DecideInput(params, points_valid, puv2, lcm_valid);
        });
    }
}