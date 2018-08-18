//思路:获取每一位上的值就是用当前位 - ‘0’；
package com.hubu.swordOffer.week05;
public class Main_字符串转换整数 {

    public int StrToInt(String str) {
       if(str == null || str.length() == 0) return 0;
       int len = str.length();
       char start = str.charAt(0);
       if ( len== 1){
           if(start > '9' || start < '0'){
               return 0;
           }
           else{
             return start - '0';
           }
       }
       int result = 0;
       int i = 1;
       int k = len - 1;
        while(k >= 1){
            if(str.charAt(k) <= '9'&&str.charAt(k) >= '0'){
                result += (str.charAt(k) - '0') * i;
                i = i * 10;
                k--;
            }else{
                return 0;
            }
        }
        if(start =='+'){
            return  result;
        }else  if(start <= '9'&&start >= '0'){
            result  = result + (start - '0') * i;
        }else if(start == '-'){
            result = ('0' - '1') * result;
        }else {
            return  0;
        }
        return result;
    }


    public static void main(String[] args) {
        int k = new Main_字符串转换整数().StrToInt("123");
        System.out.println(k);
    }
}
