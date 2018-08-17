//思路一:直接用StringBuffer类的方法替换
//思路二:遍历str,遇到空格就append%20,遇到字符就append()这个字符
package com.hubu.swordOffer.week01;

public class Main_空格替换 {
    public String replaceSpace(StringBuffer str) {
         if(str == null) return null;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
    public static  void main(String[] args){
      StringBuffer sb = new StringBuffer("We Are Happy!");
      String res = new Main_空格替换().replaceSpace(sb);
      System.out.println(res);
    }
}
