//思路：先转换为二进制的字符串的表示形式，然后遍历字符串即可统计1的个数
package com.hubu.swordOffer.week02;

public class Main_二进制1的个数 {
    public int NumberOf1(int n) {
        int res = 0;
        String str= Integer.toBinaryString(n);
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) == '1'){
                res++;
            }
        }
        return res;
    }
    //测试
    public static void main(String[] args){
        int n = 2;
        String str = Integer.toBinaryString(n);
        System.out.println(str);
    }
}
