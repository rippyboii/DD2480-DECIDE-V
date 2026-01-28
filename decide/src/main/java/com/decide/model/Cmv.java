package com.decide.model;
import com.decide.lics.*;


public class Cmv {
    private Lic[] licList;

    /**
     * Constructor for Cmv class
     */
    public Cmv() {
        this.licList = new Lic[] {  new Lic0(),
                                    new Lic1(),
                                    new Lic2(),
                                    new Lic3(),
                                    new Lic4(),
                                    new Lic5(),
                                    new Lic6(),
                                    new Lic7(),
                                    new Lic8(),
                                    new Lic9(),
                                    new Lic10(),
                                    new Lic11(),
                                    new Lic12(),
                                    new Lic13(),
                                    new Lic14(),
        };
    }

    /**
     * Evaluates all LICs and returns the CMV array.
     * @param points The set of points
     * @param params The parameters
     * @return The CMV array
     */
    public boolean[] evaluate(Point[] points, Parameters params) {
        boolean[] cmv = new boolean[this.licList.length];
        for (int i = 0; i < cmv.length; i++) {
            cmv[i] = this.licList[i].evaluate(points, params);
        }
        return cmv;
    }
}
