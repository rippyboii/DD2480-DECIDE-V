package com.decide.model;
import com.decide.LICs.LIC;
import com.decide.LICs.LIC0;
import com.decide.LICs.LIC1;
import com.decide.LICs.LIC10;
import com.decide.LICs.LIC11;
import com.decide.LICs.LIC12;
import com.decide.LICs.LIC13;
import com.decide.LICs.LIC14;
import com.decide.LICs.LIC2;
import com.decide.LICs.LIC3;
import com.decide.LICs.LIC4;
import com.decide.LICs.LIC5;
import com.decide.LICs.LIC6;
import com.decide.LICs.LIC7;
import com.decide.LICs.LIC8;
import com.decide.LICs.LIC9;


public class CMV {
    private LIC[] LIClist;

    public CMV() {
        this.LIClist = new LIC[] {  new LIC0(),
                                    new LIC1(),
                                    new LIC2(),
                                    new LIC3(),
                                    new LIC4(),
                                    new LIC5(),
                                    new LIC6(),
                                    new LIC7(),
                                    new LIC8(),
                                    new LIC9(),
                                    new LIC10(),
                                    new LIC11(),
                                    new LIC12(),
                                    new LIC13(),
                                    new LIC14(),
        };
    }

    public boolean[] evaluate(Point[] points, Parameters params) {
        boolean[] cmv = new boolean[this.LIClist.length];
        for (int i = 0; i < cmv.length; i++) {
            cmv[i] = this.LIClist[i].evaluate(points, params);
        }
        return cmv;
    }
}
