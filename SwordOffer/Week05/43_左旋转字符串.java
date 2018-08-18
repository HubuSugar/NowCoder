//思路:以n为界限将字符串分成两边
package com.hubu.swordOffer.week05;

public class Main_左旋转字符串 {

    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) return "";
        if(n < 0) return str;
        int len = str.length();
        if(n >= len) return str;
        char[] temp = new char[len];

        int index = 0;
        for(int j = n;j < len;j++){
            temp[index++] = str.charAt(j);
        }
        for(int i = 0;i < n;i++){
            temp[index++] = str.charAt(i);
        }
         return String.valueOf(temp);
    }


    public static void main(String[] args) {
        String str = "abcXYZdef";
         String res = new Main_左旋转字符串().LeftRotateString(str,9);
        System.out.println(res);
    }
}
