//思路：将一个数字分为三部分当前位current、高位before、低位after，然后分为current分别为0,1,大于1；三种情况讨论:
//当为 == 0时 count += before * i(i表示当前位的权重)；==1时 count += before * i + after + 1; > 1时 count += (before + 1) * i;
package com.hubu.swordOffer.week04;

public class Main_整数中1的次数{

    public static int NumberOf1Between1AndN_Solution(int n) {

        int count = 0;   //一的个数
        int i = 1;    //当前位
        int current = 0,before = 0,after = 0;
        while((n / i) != 0){

            current = (n / i) % 10;        //当前位数字
            before = n / (i * 10);           //高位数字
            after = n - (n / i) * i;            //地位数字

            if(current == 0){
                count += before * i;
            }
            else if(current == 1){
                count += before * i + after + 1;
            }else{
                count += (before + 1) * i;
            }

            i = i * 10;

        }

        return count;
    }
    public static void main(String[] args) {

        int  num = 12345;
        int n = NumberOf1Between1AndN_Solution(num);
        System.out.println(n);
    }



}
