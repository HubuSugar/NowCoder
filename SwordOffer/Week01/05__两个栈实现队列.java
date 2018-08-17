package com.hubu.swordOffer.week01;

import java.util.Stack;

public class Main_两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //直接入栈
    public void push(int node) {
        stack1.push(node);
    }

    //出栈为Stack2的栈顶
    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        return  stack2.pop();
    }
}
