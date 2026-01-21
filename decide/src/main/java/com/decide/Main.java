package com.decide;

import com.decide.model.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1.0, 2.0));
        points.add(new Point(3.0, 4.0));

        Parameters params = new Parameters();
        boolean[] puv = new boolean[]{true, false};
        Connector[][] lcm = new Connector[][]{
            {Connector.AND, Connector.OR},
            {Connector.NOT_USED, Connector.AND}
        };
        
        DecideInput input = new DecideInput(params, points, puv, lcm);

        System.out.println("Number of points: " + input.getNumPoints());
    }

}