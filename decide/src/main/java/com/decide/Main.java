package com.decide;

import com.decide.model.*;

public class Main {
    public static void main(String[] args) {
                Point[] points = {
        new Point(0.0, 0.0),
        new Point(1.0, 0.0),
        new Point(2.0, 1.0),
        new Point(3.0, -1.0),
        new Point(-3.0, 3.0)
        };
        boolean[] puv = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        Connector[][] lcm = new Connector[15][15];
        for (int i = 0; i < 15; i++) {
        for (int j = 0; j < 15; j++) {
            lcm[i][j] = Connector.AND; 
        }
        }
        Parameters parameters = new Parameters();
        parameters.setLENGTH1(1.0);
        parameters.setRADIUS1(5.5);
        parameters.setEPSILON(0.1);
        parameters.setAREA1(0.5);
        parameters.setQ_PTS(4);
        parameters.setQUADS(2);
        parameters.setN_PTS(3);
        parameters.setDIST(0.1);
        parameters.setK_PTS(2);
        parameters.setA_PTS(1);
        parameters.setB_PTS(1);
        parameters.setC_PTS(1);
        parameters.setD_PTS(1);
        parameters.setE_PTS(1);
        parameters.setF_PTS(1);
        parameters.setG_PTS(1);
        parameters.setLENGTH2(5.0);
        parameters.setRADIUS2(10.0);
        parameters.setAREA2(10.0);

    

        Demo demo = new Demo(points, parameters, lcm, puv);
        boolean launchDecision = demo.runDemo();
        if(launchDecision) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}