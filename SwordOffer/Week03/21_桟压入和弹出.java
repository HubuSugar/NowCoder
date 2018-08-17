//思路：借助一个辅助栈，模拟入栈和出栈的过程，每入栈一个元素后，判断出栈序列时候与之相等，
//如果相等那么将这个入栈的元素出栈，如果不相等，那么入栈下一个元素，最后返回辅助栈是否为空。
package com.hubu.swordOffer.week03;

import java.util.Stack;

public class Main_桟压入和弹出{

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        if(pushA == null || popA == null) return false;
        if(pushA.length == 0|| popA.length == 0) return false;
        int len = pushA.length;
        //记录出栈序列的下标
        int popIndex = 0;
        //循环入栈
        for(int i = 0;i < len;i++ ){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && popA[popIndex] == stack.peek()){
                stack.pop();
                popIndex++;
            }
        }
       return stack.isEmpty();
    }

    public static void main(String[] args) {

       int[] pushA = {1,2,3,4,5};
       int[] popA = {4,5,3,2,1};
       int[] popB = {4,3,5,1,2};
       boolean f1 = new Main_桟压入和弹出().IsPopOrder(pushA,popA);
       boolean f2 =  new Main_桟压入和弹出().IsPopOrder(pushA,popB);
       System.out.println("f1:"+f1 + ";f2:"+ f2);
    }

}
