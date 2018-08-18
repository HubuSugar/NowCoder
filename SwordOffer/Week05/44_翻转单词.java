//思路:按空格截取字符串
package com.hubu.swordOffer.week05;

public class Main_翻转单词{


    public String ReverseSentence(String str) {

        if (str == null) return null;
        if(str.trim().length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        String[] strings = str.split(" ");
        for(int i =strings.length - 1; i >=0;i--){
            if(i == strings.length -1){
                sb = new StringBuilder(strings[strings.length - 1]);
            }
            else{
                sb.append(" " + strings[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

       // String str= "student. a am I";
        String str = " ";
        String  res =  new Main_翻转单词().ReverseSentence(str);
        System.out.println(res);
    }


}
