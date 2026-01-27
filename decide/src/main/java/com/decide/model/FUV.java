package com.decide.model;

public class Fuv {
    boolean [] puv;
    boolean [][] pum;

    public Fuv(boolean [] puv, boolean [][] pum){
        this.puv = puv;
        this.pum = pum;
    }

    public boolean[] calculateFuv(){

        int n = this.puv.length;
        boolean [] fuv = new boolean [n];
        boolean row_true;

        //Evaluate every row of PUV and PUM
        for (int i = 0; i < n; i++){
            row_true = true;
            for (int j = 0; j < n; j++){
                //Check for false boolean in PUM row
                if(!this.pum[i][j] && i != j){
                    row_true = false;
                }
            }
            if(!this.puv[i] || row_true){
                fuv[i] = true;
            }
        }
        return fuv;
    }
}
