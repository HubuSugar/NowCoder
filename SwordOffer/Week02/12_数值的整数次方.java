package com.hubu.swordOffer.week02;

public class Main_数值的整数次方{
    public double Power(double base, int exponent) {
        if(base == 0) return 0.0;
       return  Math.pow(base,(double)exponent);
    }

    public static void main(String[] args){

        double d = new S12().Power(0,-1);
        System.out.println(d);
    }
}
