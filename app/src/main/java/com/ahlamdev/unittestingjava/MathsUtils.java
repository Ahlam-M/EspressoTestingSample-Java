package com.ahlamdev.unittestingjava;

import android.text.Editable;

public class MathsUtils {

    static String add(Editable e1, Editable e2){
        //adding operation
        double d = pre.forOp(e1) + pre.forOp(e2);
        return pre.toShow(d);
    }
}

class pre {

    static double forOp(Editable ed){
        return Double.parseDouble(ed.toString());
    }

    static String toShow(double i){
        if(i == Math.floor(i))
            return String.valueOf((int)i);
        return String.valueOf(i);
    }
}

