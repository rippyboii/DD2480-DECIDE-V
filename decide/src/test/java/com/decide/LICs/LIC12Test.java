package com.decide.LICs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.decide.model.Parameters;
import com.decide.model.Point;

public class LIC12Test {
    /**
     * Contract:
     * LIC12 shall return FALSE when the number of points is less than 3, as the condition cannot be met.
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
        LIC12 lic12 = new LIC12();
        assertFalse(lic12.evaluate(points, params));
    }
}
