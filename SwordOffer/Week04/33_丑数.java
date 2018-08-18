//思路:每次比较三个数
package com.hubu.swordOffer.week04;

import java.util.ArrayList;

public class Main_丑数{


    public int GetUglyNumber_Solution(int index) {

        ArrayList<Integer>  list = new ArrayList<>();
        if(index <= 0)   return 0;
        int i  = 0;     //表示2的个数
        int j  = 0;     //表示3的个数
        int k = 0;     //表示5的个数
        list.add(1);
        while(list.size() < index) {

              int m2 = list.get(i) * 2;  
              int m3 = list.get(j) * 3;
              int m5 = list.get(k) * 5;
              int min = Math.min(m2,Math.min(m3,m5));
              list.add(min);
              if(min == m2) i++;
              if(min == m3) j++;
              if(min == m5) k++;

        }

        return list.get(list.size() - 1);
    }


    public static void main(String[] args) {

        int num = new Main_丑数().GetUglyNumber_Solution(20);
        System.out.println(num);

    }



}
