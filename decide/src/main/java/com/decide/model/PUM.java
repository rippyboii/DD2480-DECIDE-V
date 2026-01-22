package com.decide.model;

public class PUM {
    private boolean[][] pum;
    private Connector[][] lcm;
    private boolean [] cmv;

    public PUM(Connector[][] lcm, boolean []cmv) {
        this.lcm = lcm;
        this.cmv = cmv;

    }
    public void calculate_PUM(){
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
        this.pum = pum;

    }
    public boolean [][] getPUM(){
        return this.pum;
    }
}
