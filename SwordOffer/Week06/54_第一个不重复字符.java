//思路:用HashMap记录每个字符的次数
package com.hubu.swordOffer.week06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main_第一个不重复字符 {

     ArrayList<Character> list = new ArrayList<>();
     Map<Character,Integer> map = new HashMap<Character,Integer>();
     char res = '#';
    public void Insert(char ch)
    {
       list.add(ch);
       if(list.size() == 1){
           res = ch;
       }
       if(!map.containsKey(ch)){
           map.put(ch,1);
       }
       else{
           map.put(ch,map.get(ch) + 1);
       }
       if(ch == res|| res == '#'){
           int i;
           for( i = 0;i < list.size();i++){
               char temp = list.get(i);
               if(map.get(temp) == 1){
                   res = temp;
                   break;
               }
           }

       }
    }


    public void a(){
        char[] c = {'g','o','o','g','l','e'};
        for(int i = 0;i < c.length; i++){
            Insert(c[i]);
            System.out.print("加入字符"+ c[i] +"后,第一个只出现一次的字符:"+FirstAppearingOnce());
            System.out.println();
        }
    }

    public char FirstAppearingOnce()
    {
        return res;
    }


    public static void main(String[] args) {
        new 第一个不重复字符().a();
    }
}
