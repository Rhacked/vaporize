package com.ninekone.liquidsmoke.calculator;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Rubenhag on 16.10.2015.
 */
public class Calculator {


    public static double getNico(double total, double tarNico, double strength){
        return (tarNico/strength)*total;
    }

    public static double getMili(double total, double percent){
        return (total*percent)/100;
    }

    public static double getPG(double amount, double tarNico, double tarPG ,double strength , double pgEJuice, double flav1, double pgFlav1, double flav2, double pgFlav2, double wvp){
        double pgFromJuice = (getNico(amount, tarNico, strength)*pgEJuice)/100;
        double pgFromFlavor1 = (getMili(amount, flav1)*pgFlav1)/100;
        double pgFromFlavor2 = (getMili(amount, flav2)*pgFlav2)/100;
        double pgRes = pgFromJuice+pgFromFlavor1+pgFromFlavor2;
        double pgNeeded = ((tarPG*amount)/100)-pgRes+(wvp/2);
        Log.d("PG", "PG needed: "+pgNeeded);
        return pgNeeded;
    }

    public static double getVG(double amount, double tarNico, double tarVG, double strength, double vgEJuice, double flav1, double vgFlav1, double flav2, double vgFlav2, double wvp){
        double vgFromJuice = (getNico(amount, tarNico, strength)*vgEJuice)/100;
        double vgFromFlavor1 = (getMili(amount, flav1)*vgFlav1)/100;
        double vgFromFlavor2 = (getMili(amount, flav2)*vgFlav2)/100;
        double vgRes = vgFromJuice+vgFromFlavor1+vgFromFlavor2;
        double vgNeeded = ((tarVG*amount)/100)-vgRes+(wvp/2);
        Log.d("PG", "PG needed: "+vgNeeded);
        return vgNeeded;
    }

}
