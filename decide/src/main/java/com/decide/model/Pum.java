package com.decide.model;

public class Pum {
    private Connector[][] lcm;
    private boolean [] cmv;

    public Pum(Connector[][] lcm, boolean []cmv) {
        this.lcm = lcm;
        this.cmv = cmv;

    }

    /**
     * Calculates the PUM based on the CMV and LCM
     */
    public boolean[][] calculatePum(){
        int n = cmv.length;
        boolean [][] pum = new boolean [n][n];

        //Matrices are expected to be symmetric, therefore only need to check one half of the diagonal
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                Connector state = lcm[i][j];

                if (state == Connector.NOT_USED){
                    pum[i][j] = true;
                    pum[j][i] = true;
                }
                else if (state == Connector.OR){
                    if (cmv[j] || cmv[i]){
                        pum[i][j] = true;
                        pum[j][i] = true;
                    }
                    else{
                        pum[i][j] = false;
                        pum[j][i] = false;
                    }
                }
                else if (state == Connector.AND){
                    if (cmv[i] && cmv[j]){
                        pum[i][j] = true;
                        pum[j][i] = true;                            
                    }
                    else{
                        pum[i][j] = false;
                        pum[j][i] = false;
                    }
                }
            }
        }
        return pum;

    }

}
