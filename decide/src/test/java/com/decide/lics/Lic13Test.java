package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class Lic13Test {
    /**
     * Contract:
     * The Lic13 requires parameters A_PTS, B_PTS to be greater or eqaul to 1, and their sum to be less 
     * or equal to number of points minus 3. ParameterTest ensures the lower bounds of A_PTS and B_PTS.
     * 
     * Expected behavior:
     * For number of point equal to 5, and A_PTS = 2, B_PTS = 2, the function shall throw Illegal Agument Exception.
     */
    @Test
    void throwIllegalArgumentForInvalidParameters() {
        Lic13 lic13 = new Lic13();
        Point[] points = {new Point(0, 0),
                        new Point(2, 3),
                        new Point(2, 0),
                        new Point(3, 0),
                        new Point(3, 2)
        };
        Parameters params = new Parameters();
        params.setA_PTS(2);
        params.setB_PTS(2);
        params.setRADIUS1(1);
        params.setRADIUS2(1);
        // A_PTS + B_PTS is greater than NUMPOINTS - 3, shall throw Illegal Argument
        assertThrows(IllegalArgumentException.class, 
            () -> {
            lic13.evaluate(points, params);
        });
    }


    /**
     * Contract:
     * Lic13 shall return false when the number of points is smaller than 5, as the condition cannot be met.
     * 
     * Expected behavior:
     * When supplied with 4 points, the function shall return false.
     */
    @Test
    void returnsFalseWhenFewerThan5Points() {
        Point[] points = {new Point(0, 0),
                        new Point(0, 0),
                        new Point(0, 0),
                        new Point(0, 0)
        };
        Parameters params = new Parameters();
        Lic13 Lic13 = new Lic13();
        assertFalse(Lic13.evaluate(points, params));
    }

    /**
     * Contract:
     * Lic13 shall return true iff there exists a set of 3 points seperated respectively by A_PTS and B_PTS number of points, 
     * which cannot be contained within or on a circle with RADIUS1,
     * AND if there exists a set of 3 points (separated ...) which can be contained within or on a circle with RADIUS2.
     * 
     * Expected behavior:
     * When supplied with a set of point where there exists a set, which cannot be contained by a circle with RADIUS1,
     * but no set which can be contained by a circle with RADIUS2, the function shall return false.
     */
    @Test
    void returnsFalseWhenOnlyCannotBeContainedIsFulfilled() {
        Point[] points = {new Point(10, 20),
                        new Point(20, 20),
                        new Point(40, 30),
                        new Point(-20, -20),
                        new Point(-20, 20),
                        new Point(20, 210),
                        new Point(100, 100),
                        new Point(23, 24),
        };
        Parameters params = new Parameters();
        params.setA_PTS(2);
        params.setB_PTS(2);
        params.setRADIUS1(1);
        params.setRADIUS2(1);
        Lic13 Lic13 = new Lic13();
        assertFalse(Lic13.evaluate(points, params));
    }

    /**
     * Contract:
     * Lic13 shall return true iff there exists a set of 3 points seperated respectively by A_PTS and B_PTS number of points, 
     * which cannot be contained within or on a circle with RADIUS1,
     * AND if there exists a set of 3 points (separated ...) which can be contained within or on a circle with RADIUS2.
     * 
     * Expected behavior:
     * When supplied with a set of point where there exists a set, which can be contained by a circle with RADIUS2,
     * but no set which cannot be contained by a circle with RADIUS1, the function shall return false.
     */
    @Test
    void returnsFalseWhenOnlyCanBeContainedIsFulfilled() {
        Point[] points = {new Point(1, 1),
                        new Point(2, 2),
                        new Point(1, 0),
                        new Point(-1, 3),
                        new Point(-1, -2),
                        new Point(1, 2),
        };
        Parameters params = new Parameters();
        params.setA_PTS(1);
        params.setB_PTS(1);
        params.setRADIUS1(5);
        params.setRADIUS2(5);
        Lic13 Lic13 = new Lic13();
        assertFalse(Lic13.evaluate(points, params));
    }

    /**
     * Contract:
     * Lic13 shall return true iff there exists a set of 3 points seperated respectively by A_PTS and B_PTS number of points, 
     * which cannot be contained within or on a circle with RADIUS1,
     * AND if there exists a set of 3 points (separated ...) which can be contained within or on a circle with RADIUS2.
     * 
     * Expected behavior:
     * When supplied with a set of point where there exist sets that fulfill both conditions, the function shall return true.
     * Here, A_PTS = B_PTS = 1, RADIUS1 = 3, RADISU2 = 1.5.
     * Points (0,1), (3,-2), (0,4) cannot be contained by a circle with RADIUS1.
     * Points (2,2), (3,4), (2,3) can be contained by a circle with RADIUS2.
     */
    @Test
    void returnsTrueWhenBothConditionsFulfilled() {
        Point[] points = {new Point(0, 1),
                        new Point(2, 2),
                        new Point(3, -2),
                        new Point(3, 4),
                        new Point(0, 4),
                        new Point(2, 3),
        };
        Parameters params = new Parameters();
        params.setA_PTS(1);
        params.setB_PTS(1);
        params.setRADIUS1(3);
        params.setRADIUS2(1.5);
        Lic13 Lic13 = new Lic13();
        assertTrue(Lic13.evaluate(points, params));
    }

}
