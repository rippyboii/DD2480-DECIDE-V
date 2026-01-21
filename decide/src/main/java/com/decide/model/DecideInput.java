package com.decide.model;

public class DecideInput {
    public Parameters parameters;
    public List<Point> points;
    public boolean[] puv;
    public Connector[][] lcm;

    /**
     * Constructor for DecideInput
     * @param params Parameters of program
     * @param points List of Points
     * @param puv Vector of booleans representing PUV
     * @param lcm Matrix of Connectors
     */
    public DecideInput(Parameters params, List<Point> points, boolean[] puv, Connector[][] lcm) {
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