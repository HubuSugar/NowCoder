    //可以证明两个数的差值越大,那么他们的乘积越小
package com.hubu.swordOffer.week05;

import java.util.ArrayList;

public class Main_和为S的两个数{

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
         ArrayList<Integer> res = new ArrayList<>();
         ArrayList<Integer> temp = new ArrayList<>();
         for(int i = 0;i < array.length;i++){
             temp.add(array[i]);
         }
         for (int i = 0;i < array.length;i++){
             if(temp.contains(sum - array[i]) && sum != 2 * array[i]){
                 res.add(array[i]);
                 res.add(sum - array[i]);
                 break;
             }
         }
         return res;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        ArrayList<Integer> list = new Main_和为S的两个数().FindNumbersWithSum(array,5);
        System.out.println(list);
    }
}
