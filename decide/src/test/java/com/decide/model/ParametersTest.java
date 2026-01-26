package com.decide.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * NOTE: Tests related to NUMPOINTS are omitted since NUMPOINTS is derived from the 
 * length of the points array and is not an explicit parameter in the Parameters class.
 */

public class ParametersTest {
    
    private Parameters params;

    @BeforeEach
    void setUp() {
        params = new Parameters();
    }

    /* #region Length */

    /**
     * Contract:
     * LIC parameters LENGTH1 and LENGTH2 shall be non-negative.
     * 
     * Expected Behavior:
     * When provided with a negative value, the setter methods should throw an
     * IllegalArgumentException.
     */
    @Test
    void throwsExceptionForNegativeLength1() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setLENGTH1(-5.0);
        });
    }

    @Test
    void throwsExceptionForNegativeLength2() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setLENGTH2(-8.0);
        });
    }

    /**
     * Contract:
     * LIC parameters AREA1 and AREA2 shall be non-negative.
     * 
     * Expected Behavior:
     * When provided with a negative value, the setter methods should throw an
     * IllegalArgumentException.
     */
    @Test
    void returnsValidLength1() {
        params.setLENGTH1(10.0);
        assertEquals(10.0, params.getLENGTH1());
    }

    @Test
    void returnsValidLength2() {
        params.setLENGTH2(15.0);
        assertEquals(15.0, params.getLENGTH2());
    }
    /* #endregion */

    /* #region Radius */

    /**
     * Contract:
     * LIC parameters RADIUS1 and RADIUS2 shall be non-negative.
     * 
     * Expected Behavior:
     * When provided with a negative value, the setter methods should throw an
     * IllegalArgumentException.
     */
    @Test
    void throwsExceptionForNegativeRadius1() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setRADIUS1(-3.0);
        });
    }

    @Test
    void throwsExceptionForNegativeRadius2() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setRADIUS2(-6.0);
        });
    }

    @Test
    void returnsValidRadius1() {
        params.setRADIUS1(7.0);
        assertEquals(7.0, params.getRADIUS1());
    }

    @Test
    void returnsValidRadius2() {
        params.setRADIUS2(14.0);
        assertEquals(14.0, params.getRADIUS2());
    }

    /* #endregion */

    /* #region Area */

    /**
     * Contract:
     * LIC parameters AREA1 and AREA2 shall be non-negative.
     * 
     * Expected Behavior:
     * When provided with a negative value, the setter methods should throw an
     * IllegalArgumentException.
     */
    @Test
    void throwsExceptionForNegativeArea() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setAREA1(-4.0);
        });
    }

    @Test
    void throwsExceptionForNegativeArea2() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setAREA2(-9.0);
        });
    }

    @Test
    void returnsValidArea1() {
        params.setAREA1(12.0);
        assertEquals(12.0, params.getAREA1());
    }

    @Test
    void returnsValidArea2() {
        params.setAREA2(20.0);
        assertEquals(20.0, params.getAREA2());
    }
    /* #endregion */

    /* #region Epsilon */

    /**
     * Contract:
     * LIC parameter EPSILON shall be in the range [0, pi].
     * 
     * Expected Behavior:
     * When provided with a value less than 0, the setter method should throw an
     * IllegalArgumentException.
     */
    @Test
    void throwsExceptionForEpsilonSmallerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setEPSILON(-0.1);
        });
    }

    /**
     * Contract:
     * LIC parameter EPSILON shall be in the range [0, pi].
     * 
     * Expected Behavior:
     * When provided with a value greater than pi, the setter method should throw an
     * IllegalArgumentException.
     */
    @Test
    void throwsExceptionForEpsilonGreaterThanPi() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setEPSILON(Math.PI + 0.1);
        });
    }

    /**
     * Contract:
     * LIC parameter EPSILON shall be in the range [0, pi].
     * 
     * Expected Behavior:
     * When provided with a value in the range [0, pi], the setter method should
     * correctly set and the getter method should return the same value.
     */
    @Test
    void returnsValidEpsilon() {
        params.setEPSILON(Math.PI / 4);
        assertEquals(Math.PI / 4, params.getEPSILON());
    }
    /* #endregion */

    /* #region Normal Points */

    /**
     * Contract:
     * LIC parameters A_PTS, B_PTS, C_PTS, D_PTS, E_PTS, F_PTS, G_PTS shall be 
     * larger than or equal to 1.
     * 
     * Expected Behavior:
     * When provided with a value less than 1, the setter methods should throw an
     * IllegalArgumentException.
     */
    @Test
    void throwsExceptionForAPtsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setA_PTS(0);
        });
    }

    @Test
    void throwsExceptionForBPtsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setB_PTS(0);
        });
    }

    @Test
    void throwsExceptionForCPtsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setC_PTS(0);
        });
    }

    @Test
    void throwsExceptionForDPtsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setD_PTS(0);
        });
    }

    @Test
    void throwsExceptionForEPtsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setE_PTS(0);
        });
    }

    @Test
    void throwsExceptionForFPtsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setF_PTS(0);
        });
    }

    @Test
    void throwsExceptionForGPtsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setG_PTS(0);
        });
    }

    /**
     * Contract:
     * LIC parameters A_PTS, B_PTS, C_PTS, D_PTS, E_PTS, F_PTS, G_PTS shall be 
     * larger than or equal to 1.
     * 
     * Expected Behavior:
     * When provided with a value greater than 1, the setter methods should 
     * correctly set and the getter methods should return the same value.
     */
    @Test
    void returnsValidAPts() {
        params.setA_PTS(3);
        assertEquals(3, params.getA_PTS());
    }

    @Test
    void returnsValidBPts() {
        params.setB_PTS(3);
        assertEquals(3, params.getB_PTS());
    }

    @Test
    void returnsValidCPts() {
        params.setC_PTS(3);
        assertEquals(3, params.getC_PTS());
    }

    @Test
    void returnsValidDPts() {
        params.setD_PTS(3);
        assertEquals(3, params.getD_PTS());
    }

    @Test
    void returnsValidEPts() {
        params.setE_PTS(3);
        assertEquals(3, params.getE_PTS());
    }

    @Test
    void returnsValidFPts() {
        params.setF_PTS(3);
        assertEquals(3, params.getF_PTS());
    }

    @Test
    void returnsValidGPts() {
        params.setG_PTS(3);
        assertEquals(3, params.getG_PTS());
    }
    /* #endregion */

    /* #region Special Points */

    /**
     * Contract:
     * LIC parameters N_PTS shall be larger than or equal to 3.
     * 
     * Expected Behavior:
     * When provided with a value less than 3, the setter method should throw an
     * IllegalArgumentException.
     */
    @Test
    void throwsExceptionForNPtsLessThanThree() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setN_PTS(2);
        });
    }

    /**
     * Contract:
     * LIC parameters Q_PTS shall be larger than or equal to 2.
     * 
     * Expected Behavior:
     * When provided with a value less than 2, the setter method should throw an
     * IllegalArgumentException.
     */
    @Test
    void throwsExceptionForQPtsLessThanTwo() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setN_PTS(1);
        });
    }

    /**
     * Contract:
     * LIC parameters K_PTS shall be larger than or equal to 1.
     * 
     * Expected Behavior:
     * When provided with a value less than 1, the setter method should throw an
     * IllegalArgumentException.
     */
    @Test
    void throwsExceptionForKPtsLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            params.setK_PTS(0);
        });
    }

    /**
     * Contract:
     * LIC parameters N_PTS shall be larger than or equal to 3.
     * 
     * Expected Behavior:
     * When provided with a value greater than or equal to 3, the setter method
     * should correctly set and the getter method should return the same value.
     */
    @Test
    void returnsValidNPts() {
        params.setN_PTS(4);
        assertEquals(4, params.getN_PTS());
    }

    /**
     * Contract:
     * LIC parameters Q_PTS shall be larger than or equal to 2.
     * 
     * Expected Behavior:
     * When provided with a value greater than or equal to 2, the setter method
     * should correctly set and the getter method should return the same value.
     */
    @Test
    void returnsValidQPts() {
        params.setQ_PTS(4);
        assertEquals(4, params.getQ_PTS());
    }

    /**
     * Contract:
     * LIC parameters K_PTS shall be larger than or equal to 1.
     * 
     * Expected Behavior:
     * When provided with a value greater than or equal to 1, the setter method
     * should correctly set and the getter method should return the same value.
     */
    @Test
    void returnsValidKPts() {
        params.setK_PTS(4);
        assertEquals(4, params.getK_PTS());
    }
    /* #endregion */

}