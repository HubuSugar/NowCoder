package com.hubu.swordOffer.week03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_字符串的排列{

    public ArrayList<String> Permutation(String str) {
        List<String> list = new ArrayList<String>();
       if(str != null&& str.length() > 0){
          helper(str.toCharArray(),0,list);
          Collections.sort(list);
       }
      return (ArrayList<String>) list;
    }

    public void helper(char[] ch, int index, List<String> list){
        if(index == ch.length - 1){
            String val = String.valueOf(ch);
            if( !list.contains(val)){
                list.add(val);
            }
        }else{
                for(int j = index;j < ch.length;j++){
                    swap(ch,index,j);
                    helper(ch,index+1,list);
                    swap(ch,index,j);
                    }
            }
    }
    //交换两个位置的字符
    private void swap(char[] c,int i,int j){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
    }


    public static void main(String[] args) {

        String str = "ABC";
        ArrayList<String> list = new Main_字符串的排列().permutation(str);
        System.out.println(list);

    }

}
