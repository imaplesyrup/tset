package com.jojo.util;

public class  TpSum {
    public Integer sum(Integer w1,Integer w2){
        if (w1==-1 ||w2==-1) {
            Integer s = w1 + w2 +1;
            return s;
        }else {
            Integer s = w1 + w2;
            return s;
        }
    }
}
