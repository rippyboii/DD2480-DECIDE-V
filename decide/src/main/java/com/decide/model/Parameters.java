package com.decide.model;

public class Parameters {
    private double LENGTH1;
    private double RADIUS1;
    private double EPSILON;
    private double AREA1;
    private int Q_PTS;
    private int QUADS;
    private double DIST;
    private int N_PTS;
    private int K_PTS;
    private int A_PTS;
    private int B_PTS;
    private int C_PTS;
    private int D_PTS;
    private int E_PTS;
    private int F_PTS;
    private int G_PTS;
    private double LENGTH2;
    private double RADIUS2;
    private double AREA2;

    public double getLENGTH1() {
        return this.LENGTH1;
    }

    /**
     * Sets LENGTH1 parameter
     * @param LENGTH1 The LENGTH1 value to set, cannot be negative
     */
    public void setLENGTH1(double LENGTH1) {
        if (LENGTH1 < 0) {
            throw new IllegalArgumentException("LENGTH1 must be non-negative");
        }
        this.LENGTH1 = LENGTH1;
    }

    public double getRADIUS1() {
        return this.RADIUS1;
    }

    /**
     * Sets RADIUS1 parameter
     * @param RADIUS1 The RADIUS1 value to set, cannot be negative
     */
    public void setRADIUS1(double RADIUS1) {
        if (RADIUS1 < 0) {
            throw new IllegalArgumentException("RADIUS1 must be non-negative");
        }
        this.RADIUS1 = RADIUS1;
    }

    public double getEPSILON() {
        return this.EPSILON;
    }

    /**
     * Sets EPSILON parameter
     * @param EPSILON The EPSILON value to set, must be in range [0, pi]
     */
    public void setEPSILON(double EPSILON) {
        if (EPSILON < 0 || EPSILON > Math.PI) {
            throw new IllegalArgumentException("EPSILON must be in the range [0, pi]");
        }
        this.EPSILON = EPSILON;
    }

    public double getAREA1() {
        return this.AREA1;
    }

    /**
     * Sets AREA1 parameter
     * @param AREA1 The AREA1 value to set, cannot be negative
     */
    public void setAREA1(double AREA1) {
        if (AREA1 < 0) {
            throw new IllegalArgumentException("AREA1 must be non-negative");
        }
        this.AREA1 = AREA1;
    }

    public int getQ_PTS() {
        return this.Q_PTS;
    }

    /**
     * Sets Q_PTS parameter
     * @param Q_PTS The Q_PTS value to set, must be at least 2
     */
    public void setQ_PTS(int Q_PTS) {
        if (Q_PTS < 2) {
            throw new IllegalArgumentException("Q_PTS must be larger than or equal to 2");
        }
        this.Q_PTS = Q_PTS;
    }

    public int getQUADS() {
        return this.QUADS;
    }

    /**
     * Sets QUADS parameter
     * @param QUADS The QUADS value to set, must be in range [1, 3]
     */
    public void setQUADS(int QUADS) {
        if (QUADS < 1 || QUADS > 3) {
            throw new IllegalArgumentException("QUADS must be in the range [1, 3]");
        }
        this.QUADS = QUADS;
    }

    public double getDIST() {
        return this.DIST;
    }

    /**
     * Sets DIST parameter
     * @param DIST The DIST value to set, cannot be negative
     */
    public void setDIST(double DIST) {
        if (DIST < 0) {
            throw new IllegalArgumentException("DIST must be non-negative");
        }
        this.DIST = DIST;
    }

    public int getN_PTS() {
        return this.N_PTS;
    }

    /**
     * Sets N_PTS parameter
     * @param N_PTS The N_PTS value to set, must be at least 3
     */
    public void setN_PTS(int N_PTS) {
        if (N_PTS < 3) {
            throw new IllegalArgumentException("N_PTS must be larger than or equal to 3");
        }
        this.N_PTS = N_PTS;
    }

    public int getK_PTS() {
        return this.K_PTS;
    }

    /**
     * Sets K_PTS parameter
     * @param K_PTS The K_PTS value to set, must be at least 1
     */
    public void setK_PTS(int K_PTS) {
        if (K_PTS < 1) {
            throw new IllegalArgumentException("K_PTS must be larger than or equal to 1");
        }
        this.K_PTS = K_PTS;
    }

    public int getA_PTS() {
        return this.A_PTS;
    }

    /**
     * Sets A_PTS parameter
     * @param A_PTS The A_PTS value to set, must be at least 1
     */
    public void setA_PTS(int A_PTS) {
        if (A_PTS < 1) {
            throw new IllegalArgumentException("A_PTS must be larger than or equal to 1");
        }
        this.A_PTS = A_PTS;
    }

    public int getB_PTS() {
        return this.B_PTS;
    }

    /**
     * Sets B_PTS parameter
     * @param B_PTS The B_PTS value to set, must be at least 1
     */
    public void setB_PTS(int B_PTS) {
        if (B_PTS < 1) {
            throw new IllegalArgumentException("B_PTS must be larger than or equal to 1");
        }
        this.B_PTS = B_PTS;
    }

    public int getC_PTS() {
        return this.C_PTS;
    }

    /**
     * Sets C_PTS parameter
     * @param C_PTS The C_PTS value to set, must be at least 1
     */
    public void setC_PTS(int C_PTS) {
        if (C_PTS < 1) {
            throw new IllegalArgumentException("C_PTS must be larger than or equal to 1");
        }
        this.C_PTS = C_PTS;
    }

    public int getD_PTS() {
        return this.D_PTS;
    }

    /**
     * Sets D_PTS parameter
     * @param D_PTS The D_PTS value to set, must be at least 1
     */
    public void setD_PTS(int D_PTS) {
        if (D_PTS < 1) {
            throw new IllegalArgumentException("D_PTS must be larger than or equal to 1");
        }
        this.D_PTS = D_PTS;
    }

    public int getE_PTS() {
        return this.E_PTS;
    }

    /**
     * Sets E_PTS parameter
     * @param E_PTS The E_PTS value to set, must be at least 1
     */
    public void setE_PTS(int E_PTS) {
        if (E_PTS < 1) {
            throw new IllegalArgumentException("E_PTS must be larger than or equal to 1");
        }
        this.E_PTS = E_PTS;
    }

    public int getF_PTS() {
        return this.F_PTS;
    }

    /**
     * Sets F_PTS parameter
     * @param F_PTS The F_PTS value to set, must be at least 1
     */
    public void setF_PTS(int F_PTS) {
        if (F_PTS < 1) {
            throw new IllegalArgumentException("F_PTS must be larger than or equal to 1");
        }
        this.F_PTS = F_PTS;
    }

    public int getG_PTS() {
        return this.G_PTS;
    }

    /**
     * Sets G_PTS parameter
     * @param G_PTS The G_PTS value to set, must be at least 1
     */
    public void setG_PTS(int G_PTS) {
        if (G_PTS < 1) {
            throw new IllegalArgumentException("G_PTS must be larger than or equal to 1");
        }
        this.G_PTS = G_PTS;
    }

    public double getLENGTH2() {
        return this.LENGTH2;
    }

    /**
     * Sets LENGTH2 parameter
     * @param LENGTH2 The LENGTH2 value to set, cannot be negative
     */
    public void setLENGTH2(double LENGTH2) {
        if (LENGTH2 < 0) {
            throw new IllegalArgumentException("LENGTH2 must be non-negative");
        }
        this.LENGTH2 = LENGTH2;
    }

    public double getRADIUS2() {
        return this.RADIUS2;
    }

    /**
     * Sets RADIUS2 parameter
     * @param RADIUS2 The RADIUS2 value to set, cannot be negative
     */
    public void setRADIUS2(double RADIUS2) {
        if (RADIUS2 < 0) {
            throw new IllegalArgumentException("RADIUS2 must be non-negative");
        }
        this.RADIUS2 = RADIUS2;
    }

    public double getAREA2() {
        return this.AREA2;
    }

    /**
     * Sets AREA2 parameter
     * @param AREA2 The AREA2 value to set, cannot be negative
     */
    public void setAREA2(double AREA2) {
        if (AREA2 < 0) {
            throw new IllegalArgumentException("AREA2 must be non-negative");
        }
        this.AREA2 = AREA2;
    }
}