package com.hubu.swordOffer.week07;

import java.util.ArrayList;

public class Main_滑动窗口最大值 {

    int getMax(int[] num){
        if(num == null || num.length ==0) return 0;
        int maxVal = num[0];
        for(int i = 0; i < num.length;i++){
            maxVal = maxVal > num[i] ? maxVal : num[i];
        }
        return maxVal;
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
         ArrayList<Integer> list  = new ArrayList<>();
         if(num == null || size <= 0|| num.length < size)  return list;
         int[] temp = new int[size];
         for(int i = 0;i <= num.length - size;i++){
             int index = 0;
             for(int j = i;j < i + size;j++){
                 temp[index++] = num[j];
             }
             int res = getMax(temp);
             list.add(res);
         }
        return list;
    }


    public static void  main(String[] args){
        int[] num = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = new Main_滑动窗口最大值().maxInWindows(num,3);
        System.out.println(list);
    }

}
