//思路:定义三个标记循环检验每一位出现的的字符分别为“ + - 数字,小数点，eE”的情况
package com.hubu.swordOffer.week06;

public class Main_表示数值的字符串 {

    public boolean isNumeric(char[] str) {

        if(str == null|| str.length == 0) return false;
        boolean dot = false;      //标记小数点是否出现过
        boolean sign = false;     //+ - 号是否出现过
        boolean hasE = false;    //eE是否出现过

        for(int i = 0; i < str.length;i++){
           if(str[i] == '+' || str[i] == '-'){
               //如果+ - 是第二次出现,且前一位不是e E
               if(sign && str[i - 1] != 'e' && str[i -1] != 'E')  return  false;
               //如果+ -是第一次出现，并且前一位不是e E，也不是出现在第一位
              if(!sign && i > 0 && str[i - 1] != 'e' && str[i -1] != 'E') return false;
               sign = true;
           }
        else   if(str[i] == '.'){
               //如果第i位为小数点.
               //小数点只能出现一次，或者小数点出现在e的后面
               if(dot || hasE) return  false;
               dot = true;    //将标记该位小数点已出现
           }
         else if(str[i] == 'e' || str[i] == 'E'){
               if(hasE)  return false;
               if(i == str.length - 1) return  false;  //如果e E 是最后一位
               hasE= true;
          }
        else if(str[i] < '0' || str[i] > '9'){
               return false;
           }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
