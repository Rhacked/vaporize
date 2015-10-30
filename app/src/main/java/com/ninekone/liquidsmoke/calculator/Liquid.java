package com.ninekone.liquidsmoke.calculator;

/**
 * Created by Rubenhag on 16.10.2015.
 */
public class Liquid {

    public int PG;
    public int VG;
    public int percent;

    public Liquid(int PG, int VG, int percent) throws Exception {
        this.PG = PG;
        this.VG = VG;
        this.percent = percent;

        if(PG+VG!=100){
            throw new Exception("Wrong PG to VG ratio");
        }
    }

}
