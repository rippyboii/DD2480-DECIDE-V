package com.decide.LICs;

import com.decide.model.Parameters;
import com.decide.model.Point;

public interface LIC {
    /**
     * Evaluates the specific LIC condition.
     * @param points
     * @param params
     * @return true if the condition is met, false otherwise
     */
    public boolean evaluate(Point[] points, Parameters params);
}
