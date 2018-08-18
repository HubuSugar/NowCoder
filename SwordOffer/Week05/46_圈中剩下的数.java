package com.hubu.swordOffer.week05;

public class Main_圈中剩下的数 {

    public int LastRemaining_Solution(int n, int m) {

        if(n <= 0||m <= 0) return -1;
        if(n == 1) return 0;
        boolean[] stat = new boolean[n];   //boolean数组判断当前的人是否在圈上

        //初始时都在圈上
        for(int i = 0;i < n;i++){
            stat[i] = true;
        }

        int len = n;                 //记录初始的人数
        int index = 0;            //记录当前报数的人数
        int count = -1;         //当前报数人的下标，初始为-1

        while(n > 1){
            count++;
            if(stat[count]){
                index++;
                if(index == m &&stat[count]){
                    stat[count] = false;
                    index = 0;
                    n--;
                }
            }
            if(count == len -1){
                count = -1;
            }
        }
        int k = 0;
        for(k =0; k < len;k++){
            if(stat[k]){
                break;
            }
        }
        return  k;
    }

    public static void main(String[] args) {
        int res = new Main_圈中剩下的数().LastRemaining_Solution(10,3);
        System.out.println(res);
    }

}
