//思路:将两个数一直与或者异或
package com.hubu.swordOffer.week05;

public class Main_做加法 {

    public int Add(int num1,int num2) {

        int n1 = (num1 & num2) << 1;  //表示两个位上都为1,相加时需要进位
        int n2 = (num1 ^ num2);           //表示只有一位上为1,相加时不需要进位

        while( (n1&n2) != 0){
            num1 = n1;
            num2 = n2;
            n1 =  (num1 & num2) << 1;
            n2 = (num1 ^ num2);
        }
        return n1|n2;
    }

    public static void main(String[] args) {
        int k = new Main_做加法().Add(3,5);
        System.out.println(k);
    }
}
