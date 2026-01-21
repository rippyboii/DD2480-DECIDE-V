package com.decide.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.decide.model.*;

public class DecideInputTest {
    @Test
    public void testValidWith2Points() {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(1.0, 2.0));
        points.add(new Point(3.0, 4.0));

        Parameters params = new Parameters();
        boolean[] puv = new boolean[]{true, false};
        Connector[][] lcm = new Connector[][]{
            {Connector.AND, Connector.OR},
            {Connector.NOT_USED, Connector.AND}
        };
        
        DecideInput input = new DecideInput(params, points, puv, lcm);

        assertEquals(2, input.getNumPoints());
    }

    @Test
    public void testIValidWith2Points() {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(1.0, 2.0));
        points.add(new Point(3.0, 4.0));

        Parameters params = new Parameters();
        boolean[] puv = new boolean[]{true, false};
        Connector[][] lcm = new Connector[][]{
            {Connector.AND, Connector.OR},
            {Connector.NOT_USED, Connector.AND}
        };
        
        DecideInput input = new DecideInput(params, points, puv, lcm);

        assertEquals(2, input.getNumPoints());
    }
}
