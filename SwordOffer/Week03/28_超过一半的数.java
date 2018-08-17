//思路一: 遍历排好序的数组
//思路二：如果满足条件的数存在，那么一定是数组中间位置的元素，快速排序的思想
package com.hubu.swordOffer.week03;

import java.util.Arrays;

public class S28 {
    public int MoreThanHalfNum_Solution(int [] array){
        if(array == null|| array.length == 0){
            return 0;
        }
        int len =array.length;
        Arrays.sort(array);
        loop1: for(int i=0;i<len;i++){
            int count=0;
            for(int j = i;j < len;j++){
                if(array[j] == array[i]){
                    count++;
                    if (count > len/2){
                        return array[i];
                    }
                }
                else{
                    continue loop1;
                }
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        int k = new S28().MoreThanHalfNum_Solution(array);
        System.out.println(k);
    }
}
