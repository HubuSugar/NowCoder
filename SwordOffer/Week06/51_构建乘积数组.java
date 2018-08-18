//思路:分为上三角和下三角的两部分来计算
package com.hubu.swordOffer.week06;

public class Main_构建乘积数组 {

    public int[] multiply(int[] A) {
        if(A == null||A.length == 0) return null;
        int len = A.length;

        int[] B = new int[len];
        int[] temp = new int[len];
        if(len >=2) {
            temp[len - 1] = 1;
            for (int j = len - 2; j >= 0; j--) {
                temp[j] = temp[j + 1] * A[j + 1];
            }
        }

        B[0] = 1;
        for(int i = 1; i < len;i++){
            B[i] = B[i - 1] *A[i - 1];
        }
        for(int i = 0; i < len;i++){
            B[i] = B[i] * temp[i];
        }
        return B;
    }


    public static void main(String[] args) {

       int[] A = {1,2,3,4,5};
       int[] B =  new Main_构建乘积数组().multiply(A);
        for (Integer k:B
             ) {
            System.out.println(k);
        }

    }


}
