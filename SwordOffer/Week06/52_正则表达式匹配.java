   /**
     * 总体分为两种情况：
     * （1） 模式的第二位为'*'
     *  如果匹配串与模式串的第一位（当前位）匹配，那么有两种匹配方式：
     *        1.模式串后移两位，相当X*直接被忽略
     *        2.匹配串后移一位，继续匹配，因为后面这个*可以匹配多个字符
     *  如果匹配串与模式串的第一位（当前位）匹配不成功，那么将模式串后移两位
     *  （2）模式的第二位不为'*'
     *  如果匹配串与模式串的第一位（当前位）匹配成功，那么匹配串和模式串同时后移一位，继续匹配
     * 如果匹配串和模式串的第一位（当前位）匹配不成功，那么直接返回false
     * */
package com.hubu.swordOffer.week06;

public class Main_正则表达式匹配{
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null||pattern == null) return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str,strIndex,pattern,patternIndex);
    }

    public boolean matchCore(char[]  str,int  strIndex, char[]  pattern, int  patternIndex){

        //如果两个字符串同时匹配到末尾，那么返回成功
        if(strIndex == str.length&& patternIndex == pattern.length){
            return true;
        }

        //如果是模式串先到末尾那么返回false
        if(strIndex != str.length&& patternIndex == pattern.length){
            return false;
        }

        //如果模式串的第二位为'*',注意数组越界
       if( patternIndex + 1 < pattern.length &&  pattern[patternIndex + 1] == '*'){
            //当前位匹配成功,注意匹配串不能越界
            if((strIndex != str.length &&  str[strIndex] == pattern[patternIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')){
               return  matchCore(str,strIndex + 1,pattern,patternIndex)
                       || matchCore(str,strIndex,pattern,patternIndex + 2);
            }
            //当前位匹配不成功，模式串后移2位
            else{
                return matchCore(str,strIndex,pattern,patternIndex + 2);
            }
       }
      //如果模式串的第二位不为'*'
        if((strIndex != str.length && pattern[patternIndex] == str[strIndex])|| (strIndex != str.length && pattern[patternIndex] == '.'))
        {
            return matchCore(str,strIndex + 1,pattern,patternIndex + 1);
        }
         return false;
    }


    public static void main(String[] args) {

        String string = "aaa";
        String string1 = "ab*ac*a";
        char[] str = string.toCharArray();
        char[] pattern = string1.toCharArray();
        boolean  b= new Main_正则表达式匹配().match(str,pattern);
        System.out.println(b);

    }

}
