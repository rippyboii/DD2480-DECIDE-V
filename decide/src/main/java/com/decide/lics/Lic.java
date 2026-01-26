package com.decide.lics;

import com.decide.model.Parameters;
import com.decide.model.Point;

public interface Lic {
    /**
     * Evaluates the specific LIC condition.
     * @param points
     * @param params
     * @return true if the condition is met, false otherwise
     */
    public boolean evaluate(Point[] points, Parameters params);
}
