//思路:将字符串全部放入map集合,然后在遍历这个字符串集合，而不是map集合，因为数据放入map集合后会Hash排序
package com.hubu.swordOffer.week04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class Main_第一个只出现一次的字符{

    //返回该元素的下标
    public static int FirstNotRepeatingChar(String str) {

        if(str == null || str.length() ==0) return -1;
        int len = str.length();
        int index = -1;

        Map<Character,Integer> map = new HashMap<>();    //存放当前元素的下标

        for (int i = 0; i < len ; i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                map.put(ch,count+1);
            }else{
                map.put(ch,1);
            }
        }

        for(int i = 0;i < len;i++){
             int k = map.get(str.charAt(i));
             if (k == 1){
                   index = i;
                   break;
             }
        }
        return index;
    }


    public static void main(String[] args) {

        int index = FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp");
        System.out.println(index);
    }


}
