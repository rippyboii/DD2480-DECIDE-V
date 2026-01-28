package com.decide.model;
import java.util.Arrays;;

public class Demo {
    boolean [] puv;
    Connector [][] lcm;
    Point [] points;
    Parameters parameters;

    public Demo(Point [] points, Parameters parameters, Connector [][] lcm, boolean [] puv){
        DecideInput input = new DecideInput(parameters, Arrays.asList(points), puv, lcm);
        this.puv = input.puv;
        this.lcm = input.lcm;
        this.points = input.points.toArray(new Point[input.getNumPoints()]);
        this.parameters = input.parameters;
    }

    public boolean runDemo(){
        Cmv cmv = new Cmv();
        boolean [] cmvResult =cmv.evaluate(this.points, this.parameters);
        PUM pum = new PUM(this.lcm, cmvResult);
        pum.calculate_PUM();
        Fuv fuv = new Fuv(this.puv, pum.getPUM());
        boolean [] fuvResult = fuv.calculateFuv();
        boolean launchDecision = true;
        for (boolean fuvValue : fuvResult) {
            if (!fuvValue) {
                launchDecision = false;
                break;
            }
        }
        return launchDecision;
    }
    
    
}
