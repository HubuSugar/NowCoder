//思路：一级台阶：1种，二级台阶：2种，3级：4种，所以每级台阶都是上一级台阶总数的两倍
package com.hubu.swordOffer.week01;

public class Main_变态跳台阶{

    public int JumpFloorII(int target) {
       if(target <= 0) return -1;
       if(target == 1) return 1;
       int pre = 1;
       int cur = 0;
       for(int i = 2;i <= target;i++){
           cur = pre * 2;
           pre = cur;
       }
       return cur;
    }

    public static void main(String[] args){
       int n =  new Main_变态跳台阶().JumpFloorII(5);
       System.out.println(n);
    }
}
