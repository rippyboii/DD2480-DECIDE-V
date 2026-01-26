package com.decide.lics;

import com.decide.model.Point;
import com.decide.model.Parameters;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lic6Test {
    
/**
 * Contract:
 * Lic6 should return false when the total number of points is less than N_PTS.
 *
 * Expected Behavior:
 * Given only 2 points and N_PTS = 3, no valid set of N_PTS consecutive points
 * can be formed. Therefore, Lic6 must evaluate to false.
 */
    @Test
    public void testNotEnoughPoints() {
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(1, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 1.0;
        
        assertFalse(Lic6.evaluate(points, params));
    }
    

/**
 * Contract:
 * Lic6 should return true if there exists a set of N_PTS consecutive points
 * where at least one point lies at a distance greater than DIST from the line
 * formed by the first and last points.
 *
 * Expected Behavior:
 * For points (0,0), (2,3), (4,0), the point (2,3) lies 3 units away from the line
 * y = 0. Since DIST = 2.0 and 3 > 2.0, Lic6 must return true.
 */

    @Test
    public void testPointFarFromLine() {
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(2, 3),
            new Point(4, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 2.0;
        
        assertTrue(Lic6.evaluate(points, params));
    }


/**
 * Contract:
 * Lic6 should return false if all points in every set of N_PTS consecutive points
 * lie at a distance less than or equal to DIST from the corresponding line.
 *
 * Expected Behavior:
 * For points (0,0), (2,0.5), (4,0), the maximum distance from the line y = 0
 * is 0.5. Since 0.5 ≤ DIST = 1.0, Lic6 must return false.
 */
    
    @Test
    public void testPointCloseToLine() {
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(2, 0.5),
            new Point(4, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 1.0;
        
        assertFalse(Lic6.evaluate(points, params));
    }

/**
 * Contract:
 * Lic6 should return false if all points in every set of N_PTS consecutive points
 * lie at a distance less than or equal to DIST from the corresponding line.
 *
 * Expected Behavior:
 * For points (0,0), (2,1), (4,0), the point (2,1) lies exactly 1.0 units away
 * from the line y = 0. Since the condition requires distance > DIST,
 * and 1.0 is not greater than DIST = 1.0, Lic6 must return false.
 */ 

    @Test
    public void testExactlyAtThreshold() {
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(2, 1),
            new Point(4, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 1.0;
        
        assertFalse(Lic6.evaluate(points, params));
    }

/**
 * Contract:
 * Lic6 should evaluate all possible sets of N_PTS consecutive points and return
 * true if any one of those sets satisfies the distance condition.
 *
 * Expected Behavior:
 * Among the consecutive groups of 4 points, there exists a set where the point
 * (4,3) lies more than DIST = 2.0 units away from the line defined by the first
 * and last points of that set. Therefore, Lic6 must return true.
 */
    
    @Test
    public void testMultipleConsecutivePoints() {
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(1, 0.1),
            new Point(2, 0),
            new Point(3, 0.1),
            new Point(4, 3),  
            new Point(5, 0.1),
            new Point(6, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 4;
        params.DIST = 2.0;
        
        assertTrue(Lic6.evaluate(points, params));
    }
    

/**
 * Contract:
 * If the first and last points of a set coincide, the distance calculation depends on the implementation of pointToLineDistance.
 *
 * Expected Behavior:
 * Since the line defined by identical points (0,0) is undefined, the distance
 * from (5,5) to (0,0) is used instead. That distance exceeds DIST = 1.0,
 * so Lic6 must return true.
 */
    @Test
    public void testCoincidentEndpoints() {

        // When first and last points are the same, distance should be measured from that point
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(5, 5),
            new Point(0, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 1.0;
        
        assertTrue(Lic6.evaluate(points, params));
    }
    
}

