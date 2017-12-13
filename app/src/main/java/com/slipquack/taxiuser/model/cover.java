package com.slipquack.taxiuser.model;

/**
 * Created by Alex on 13.12.2017.
 */

public class cover {
    private String small;
    private String big;
    private String big1;
    public cover (String small, String big){
        this.small = small;
        this.big = big;
        this.big1 = big1;
    }
    public cover(){

    }

    public String getBig() {
        return big;
    }

    public String getBig1() {
        return big1;
    }

    public void setBig1(String big1) { this.big1 = big1; }

    public void setBig(String big) {
        this.big = big;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}

