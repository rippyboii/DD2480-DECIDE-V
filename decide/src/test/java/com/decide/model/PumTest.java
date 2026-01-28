package com.decide.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class PumTest {
    @Test
    public void testPumInitialization() {
        /**
         * Contract:
         * The testPumInitialization constructor should create a PUM object with the provided LCM and CMV.
         * 
         * Expected Behavior:
         * Given a valid LCM and CMV, the PUM object should be initialized correctly
         */
        
        //Dummy lcm
        Connector[][] lcm = new Connector[][]{
            {Connector.AND, Connector.NOT_USED, Connector.OR},
            {Connector.NOT_USED, Connector.AND, Connector.AND},
            {Connector.OR, Connector.AND, Connector.AND}
        };
        //Dummy cmv
        boolean [] cmv = new boolean[]{true, false, false};

        Pum pum = new Pum(lcm, cmv);

        //Expected PUM
        boolean [][] true_pum = new boolean[][]{
            {true, true, true},
            {true, false, false},
            {true, false, false}};
        boolean [][] pumResult = pum.calculatePum();
        
        //Compare boolean arrays
        for (int i = 0; i < true_pum.length; i++) {
            for (int j = i; j < true_pum.length; j++) {
                assertEquals(true_pum[i][j], pumResult[i][j], "Mismatch at position (" + i + "," + j + ")");
            }
        }
    }
}
