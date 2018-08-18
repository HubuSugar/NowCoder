//思路:排序后，计算两个相邻数
package com.hubu.swordOffer.week05;

import java.util.Arrays;

public class Main_扑克牌顺子{
    public boolean isContinuous(int [] numbers) {

        if(numbers == null || numbers.length == 0) return  false;

        int len = numbers.length;
        if(len == 1){
            if(numbers[0]<=13&&numbers[0] >= 0){
                return true;
            }else{
                return false;
            }
        }
        Arrays.sort(numbers);

        int count = 0;  //记录数组中0的个数

        //先计算数组中大小王的个数
        for(int i = 0; i < len;i++){
            if(numbers[i] == 0){
                count++;
            }
        }
        if(count > 4) {return false;}
        for (int i = count; i < len - 1; i++) {
            if (numbers[i + 1] -numbers[i] - 1 >= 1){
                count = count - (numbers[i + 1] - numbers[i] - 1);
            }
            if(numbers[i + 1] -numbers[i] - 1 == -1){
                return false;
            }
            if(count < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[]  array = {1,3};
        boolean b = new Main_扑克牌顺子().isContinuous(array);
        System.out.println(b);

    }
}
