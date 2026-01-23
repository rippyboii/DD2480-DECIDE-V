package com.decide.LICs;

import com.decide.model.Point;
import com.decide.model.Parameters;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LIC6Test {
    
    
    @Test
    public void testNotEnoughPoints() {

    // Fewer points than N_PTS
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(1, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 1.0;
        
        assertFalse(LIC6.evaluate(points, params));
    }
    
    @Test
    public void testPointFarFromLine() {
        // Line from (0,0) to (4,0), point at (2,3) is 3 units away

        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(2, 3),
            new Point(4, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 2.0;
        
        assertTrue(LIC6.evaluate(points, params));
    }
    
    @Test
    public void testPointCloseToLine() {

        // Line from (0,0) to (4,0), point at (2,0.5) is 0.5 units away
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(2, 0.5),
            new Point(4, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 1.0;
        
        assertFalse(LIC6.evaluate(points, params));
    }
    
    @Test
    public void testExactlyAtThreshold() {

        // Line from (0,0) to (4,0), point at (2,1) is 1 unit away
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(2, 1),
            new Point(4, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 3;
        params.DIST = 1.0;
        
        assertFalse(LIC6.evaluate(points, params));
    }
    
    @Test
    public void testMultipleConsecutivePoints() {

        // Should check multiple sets of N_PTS consecutive points
        Point[] points = new Point[]{
            new Point(0, 0),
            new Point(1, 0.1),
            new Point(2, 0),
            new Point(3, 0.1),
            new Point(4, 3),  // This point is far from line (3,0.1) to (6,0)
            new Point(5, 0.1),
            new Point(6, 0)
        };
        Parameters params = new Parameters();
        params.N_PTS = 4;
        params.DIST = 2.0;
        
        assertTrue(LIC6.evaluate(points, params));
    }
    
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
        
        assertTrue(LIC6.evaluate(points, params));
    }
    
}

