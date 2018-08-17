package com.hubu.swordOffer.week03;

import java.util.ArrayList;
import java.util.Collections;

public class Main_连续子数组的最大和{

    public int FindGreatestSumOfSubArray(int[] array) {

        ArrayList<Integer>  list = new ArrayList<Integer>();

        if(array == null || array.length == 0) return 0;
        int len = array.length;
        for(int i = 0;i < len;i++){
            int res = array[i]; //记录每一趟元素和最大的值
            int preValue = 0;   //记录当前元素之前所有元素的和

            for(int j = i;j < len;j++){
                preValue = preValue + array[j];
                res = res > preValue ? res : preValue;
            }
              list.add(res);
        }
        Collections.sort(list);
        return list.get(list.size() - 1);

    }

    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
         int k = new Main_连续子数组的最大和().FindGreatestSumOfSubArray(array);
        System.out.println(k);

    }
}
