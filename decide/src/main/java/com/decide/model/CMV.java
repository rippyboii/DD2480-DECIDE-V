package com.decide.model;
import com.decide.lics.Lic;
import com.decide.lics.Lic0;
import com.decide.lics.Lic1;
import com.decide.lics.Lic10;
import com.decide.lics.Lic11;
import com.decide.lics.Lic12;
import com.decide.lics.Lic13;
import com.decide.lics.Lic14;
import com.decide.lics.Lic2;
import com.decide.lics.Lic3;
import com.decide.lics.Lic4;
import com.decide.lics.Lic5;
import com.decide.lics.Lic6;
import com.decide.lics.Lic7;
import com.decide.lics.Lic8;
import com.decide.lics.Lic9;


public class CMV {
    private Lic[] LIClist;

    public CMV() {
        this.LIClist = new Lic[] {  new Lic0(),
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

    public boolean[] evaluate(Point[] points, Parameters params) {
        boolean[] cmv = new boolean[this.LIClist.length];
        for (int i = 0; i < cmv.length; i++) {
            cmv[i] = this.LIClist[i].evaluate(points, params);
        }
        return cmv;
    }
}
