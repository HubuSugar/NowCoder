     /**
      * 12 ^ 54 :   0 0 0 0 1 1  0 0
      *                ^0 0 1 1 0 1  1 0
      *                   0 0 1 1 1 0 1 0    -->这个结果肯定不为零，其中位置上为1的就是这两个元素的不同，为零的就是这两个元素相同的地方
      *                   然后从右往左找到第一个第一个1出现的地方（这个异或的结果中肯定为存在一个1）
      *                   然后根据这个1 将数组中的元素分为两组，其中一组中就有这两个不重复的数中的一个
      *                   另一组中则有这两个数字中的另外一个
      *                   然后再把这两组数字分别异或就可以找出这两个不同的数字
      *
      *       其中的规律就是：一个数与自己异或的结果是0，任何数与0 异或的结果就是自己
      * */
package com.hubu.swordOffer.week04;

public class Main_只出现一次的数字{

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

            if(array == null || array.length <= 1){
                num1[0] = num2[0] = 0;
                return;
            }
            int len = array.length;
            int index = 0;    //记录两个元素第一个不重复位置的1
            int sum = 0;     //表示这个数组中数字异或的结果，实际上就是这两个不同的数的结果，
                                     // 因为相同的数异或结果为0,0与任何数异或结果都为自身
            for(int i = 0; i < len;i++){
                sum ^= array[i];
            }
            //从右往左找出第一个记录不同的1出现的位置
            for(index = 0; index < 32; index++){
                if( (sum & (1 << index)) != 0){
                    break;
                }
            }

            //根据这个不同1的位置将数字分组
          for(int i = 0;i < len ;i++){
                if((array[i] & (1 << index) ) != 0){
                    num1[0] ^= array[i];
                }else{
                    num2[0] ^= array[i];
                }
          }

    }


    public static void main(String[] args) {

        int[] array = {1,3,3,2,1,2,12,54};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new Main_只出现一次的数字().FindNumsAppearOnce(array,num1,num2);

    }
}
