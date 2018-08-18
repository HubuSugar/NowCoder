  // 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
  // 排序规则如下：
  // 若ab > ba 则 a > b，
  // 若ab < ba 则 a < b，
  // 若ab = ba 则 a = b；
package com.hubu.swordOffer.week04;

import java.util.*;

public class Main_排成最小的数{

    public  String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
  
    public static void main(String[] args) {

        int[]  num = {3,32,321};
        new Main_排成最小的数().PrintMinNumber(num);

    }

}
