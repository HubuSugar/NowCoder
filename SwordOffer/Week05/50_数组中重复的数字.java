//思路:用map集合统计数组中的数字出现的次数
package com.hubu.swordOffer.week05;

import java.util.HashMap;
import java.util.Map;

public class Main_数组中重复的数字 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        duplication[0] = -1;
        if(numbers == null||length == 0) return false;

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i =0; i < length;i++){
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i],1);
            } else{
                int count = map.get(numbers[i]);
                map.put(numbers[i],count + 1);

            }
        }

        for(int i = 0;i<length;i++){
            if(map.get(numbers[i]) > 1){
                duplication[0] = numbers[i];
                break;
            }
        }

       if(duplication[0] == -1){
            return false;
       }else{
            return true;
       }

    }

    public static void main(String[] args) {
        int[] num = {};
        int[] dup = new int[1];
        boolean b =new Main_数组中重复的数字().duplicate(num,num.length,dup);
        System.out.println(b);
        System.out.println(dup[0]);
    }

}
