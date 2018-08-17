//思路:从前往后扫描整个数组，找到的第一个比前一个小的数就是数组中最小的元素
package com.hubu.swordOffer.week01;

public class Main_旋转数组最小数字 {

    public int minNumberInRotateArray(int [] array) {
       if(array == null || array.length == 0)  return 0;
       int len = array.length;
       //将数组的第一个元素作为基数
       int base = array[0];
        int i;
        for ( i= 0; i < len; i++) {
            if(array[i] >= base){
                base = array[i];
            }
            else{
                break;
            }
        }
        if(i == len){
            return array[0];
        }
        return array[i];
    }

    //测试
    public static void main(String[] args){
        int[] num = new int[]{};
        int res = new Main_旋转数组最小数字().minNumberInRotateArray(num);
        System.out.println(res);
    }
}
