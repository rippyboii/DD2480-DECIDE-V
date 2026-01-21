package com.decide.model;

import java.util.List;

public class DecideInput {
    public Parameters parameters;
    public List<Point> points;
    public boolean[] puv;
    public Connector[][] lcm;

    private static final int MAX_POINTS = 100;
    private static final int MIN_POINTS = 2;

    /**
     * Constructor for DecideInput
     * @param params Parameters of program
     * @param points List of Points
     * @param puv Vector of booleans representing PUV
     * @param lcm Matrix of Connectors
     * 
     * 
     */
    public DecideInput(Parameters params, List<Point> points, boolean[] puv, Connector[][] lcm) {
        if (points.size() > MAX_POINTS || points.size() < MIN_POINTS) {
            throw new IllegalArgumentException("Number of points must be between " + MIN_POINTS + " and " + MAX_POINTS);
        }
        this.parameters = params;
        this.points = points;
        this.puv = puv;
        this.lcm = lcm;
    }

    /**
     * Get the number of points
     * @return Number of points
     */
    public int getNumPoints() {
        return this.points.size();
    }
}