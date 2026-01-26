package com.decide.lics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class Lic12Test {
    /**
     * Contract:
     * The parameter K_PTS has to lie in range [-1;nPoints-2]
     *  
     * Expected behavior:
     * When the parameter K_PTS is set to zero, or set to 4 when the number of points is 5, 
     * the function shall throw IllegalArgumentException.
     */
    @Test
    void throwsInvalidArgumentForIllegalKPTS() {
        Lic12 Lic12 = new Lic12();
        Point[] points = {new Point(0, 0),
                        new Point(2, 3),
                        new Point(2, 0),
                        new Point(3, 0),
                        new Point(3, 2)
        };
        Parameters params = new Parameters();
        params.setK_PTS(0); // 
        params.setLENGTH1(3);
        params.setLENGTH2(2);
        assertThrows(IllegalArgumentException.class, 
            () -> {
            Lic12.evaluate(points, params);
        });
        params.setK_PTS(4);
        assertThrows(IllegalArgumentException.class, 
            () -> {
            Lic12.evaluate(points, params);
        });
    }



    /**
     * Contract:
     * Lic12 shall return FALSE when the number of points is less than 3, as the condition cannot be met.
     *  
     * Expected behavior:
     * When given a set of points with a length 2, the function shall return FALSE.
     */
    @Test
    void returnsFalseForLessThan3Points() {
        Point[] points = {new Point(0, 0),
                        new Point(0, 0),
        };
        Parameters params = new Parameters();
        Lic12 Lic12 = new Lic12();
        assertFalse(Lic12.evaluate(points, params));
    }

    /**
     * Contract:
     * Lic12 shall return TRUE iff there exist one set of 2 points seperated by K_PTS points, whose distance is greater than LENGTH1,
     * and one set of 2 points (seperated ..), whose distance is lesser than LENGTH2.
     * 
     * Expected behavior:
     * Given the following set of points, and parameters K_PTS = 1, LENGTH1 = 3, LENGTH2 = 2,
     * the function shall return FALSE, as the condition of two points having greater distance 
     * than LENGTH1 is met (points (2,3), (3,0)), but the second condition is never met.
     * 
     */
    @Test
    void returnsFalseWhenOnlyGreaterConditionIsMet() {
        Point[] points = {new Point(0, 0),
                        new Point(2, 3),
                        new Point(2, 0),
                        new Point(3, 0),
                        new Point(3, 2)
        };
        Parameters params = new Parameters();
        params.setK_PTS(1);
        params.setLENGTH1(3);
        params.setLENGTH2(2);
        Lic12 Lic12 = new Lic12();
        assertFalse(Lic12.evaluate(points, params));
    }

    /**
     * Contract:
     * Lic12 shall return TRUE iff there exist one set of 2 points seperated by K_PTS points, whose distance is greater than LENGTH1,
     * and one set of 2 points (seperated ..), whose distance is lesser than LENGTH2.
     * 
     * Expected behavior:
     * Given the following set of points, and parameters K_PTS = 1, LENGTH1 = 2, LENGTH2 = 2,
     * the function shall return FALSE, as the condition of two points having greater distance 
     * than LENGTH1 is never met, even though the second condition is.
     * 
     */
    @Test
    void returnsFalseWhenOnlyLesserConditionIsMet() {
        Point[] points = {new Point(0, 0),
                        new Point(2, 1),
                        new Point(2, 0),
                        new Point(1, 1),
                        new Point(1, 0)
        };
        Parameters params = new Parameters();
        params.setK_PTS(1);
        params.setLENGTH1(2);
        params.setLENGTH2(2);
        Lic12 Lic12 = new Lic12();
        assertFalse(Lic12.evaluate(points, params));
    }

    /**
     * Contract:
     * Lic12 shall return TRUE iff there exist one set of 2 points seperated by K_PTS points, whose distance is greater than LENGTH1,
     * and one set of 2 points (seperated ..), whose distance is lesser than LENGTH2.
     * 
     * Expected behavior:
     * Given the following set of points, and parameters K_PTS = 1, LENGTH1 = 2, LENGTH2 = 2,
     * the function shall return TRUE, as both conditions are met.
     * 
     */
    @Test
    void returnsTrueWhenBothConditionsAreMet() {
        Point[] points = {new Point(0, 0),
                        new Point(2, 0),
                        new Point(2, 1),
                        new Point(1, 1),
                        new Point(1, 0)
        };
        Parameters params = new Parameters();
        params.setK_PTS(1);
        params.setLENGTH1(2);
        params.setLENGTH2(2);
        Lic12 Lic12 = new Lic12();
        assertTrue(Lic12.evaluate(points, params));
    }
}
