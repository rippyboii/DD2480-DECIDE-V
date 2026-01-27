package com.decide.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FuvTest {
    @Test
    public void testNoTrueRowsFUV() {
        /**
         * Contract:
         * FUV[i] should be set to true if PUV[i] is 
         * false (indicating that the associated LIC should not hold back launch) or if all elements 
         * in PUM row i are true.
         * Expected Behavior:
         * With an agreeing PUV and PUM the FUV should have a corresponding boolean value
         */
        
        
        //Dummy PUV
        boolean [] puv = new boolean[]{false, true, true};
        //Dummy PUM
        boolean [][] pum = new boolean[][]{
            {true, true, true},
            {true, false, false},
            {true, false, false}};
        Fuv fuv = new Fuv(puv, pum);
        boolean[] fuv_output = fuv.calculateFuv();

        assertTrue(fuv_output[0]);
        assertFalse(fuv_output[1]);
        assertFalse(fuv_output[2]);
    }
    
    @Test
    public void testTruePUMFUV() {
        /**
         * Contract:
         * FUV[i] should be set to true if PUV[i] is 
         * false (indicating that the associated LIC should not hold back launch) or if all elements 
         * in PUM row i are true.
         * Expected Behavior:
         * Given a PUV filled with true values and a PUM filled with true values the FUV should
         * be all true
         */
        
        
        //Dummy PUV
        boolean [] puv = new boolean[]{true, true, true};
        //Dummy PUM
        boolean [][] pum = new boolean[][]{
            {true, true, true},
            {true, true, true},
            {true, true, true}};
        Fuv fuv = new Fuv(puv, pum);
        boolean[] fuv_output = fuv.calculateFuv();

        assertTrue(fuv_output[0]);
        assertTrue(fuv_output[1]);
        assertTrue(fuv_output[2]);
        
    } 

    @Test
    public void testFalsePUVFUV() {
        /**
         * Contract:
         * FUV[i] should be set to true if PUV[i] is 
         * false (indicating that the associated LIC should not hold back launch) or if all elements 
         * in PUM row i are true.
         * Expected Behavior:
         * Given a PUV filled with false values and a PUM filled with false values the FUV should
         * be all true
         */
        
        
        //Dummy PUV
        boolean [] puv = new boolean[]{false, false, false};
        //Dummy PUM
        boolean [][] pum = new boolean[][]{
            {false, false, false},
            {false, false, false},
            {false, false, false}};
        Fuv fuv = new Fuv(puv, pum);
        boolean[] fuv_output = fuv.calculateFuv();

        assertTrue(fuv_output[0]);
        assertTrue(fuv_output[1]);
        assertTrue(fuv_output[2]);
        
    } 

    @Test
    public void testFalseDiagonalPUMFUV() {
        /**
         * Contract:
         * FUV[i] should be set to true if PUV[i] is 
         * false (indicating that the associated LIC should not hold back launch) or if all elements 
         * in PUM row i are true.
         * Expected Behavior:
         * Given a PUV filled with true values and a PUM filled with true values except for the diagonal, the FUV should
         * be all true
         */
        
        
        //Dummy PUV
        boolean [] puv = new boolean[]{false, false, false};
        //Dummy PUM
        boolean [][] pum = new boolean[][]{
            {false, true, true},
            {true, false, true},
            {true, true, false}};
        Fuv fuv = new Fuv(puv, pum);
        boolean[] fuv_output = fuv.calculateFuv();

        assertTrue(fuv_output[0]);
        assertTrue(fuv_output[1]);
        assertTrue(fuv_output[2]);
    } 
}
