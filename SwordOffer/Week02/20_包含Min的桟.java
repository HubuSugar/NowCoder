package com.hubu.swordOffer.week02;

import java.util.Iterator;
import java.util.Stack;

public class Main_包含Min的桟{

    static int count = 0;   //定义全局变量记录值最小的元素入栈次数
    static  Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
       //每次进栈注意更新最小值栈中的值
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }
        else {
            if(minStack.peek() > node){
                minStack.pop();
                minStack.push(node);
               count = 1;
            }
            else if(minStack.peek() == node){
                count++;
            }
        }

    }

    public void pop() {
     //出栈也要判断当前最小值是否出栈
        if(!minStack.isEmpty()) {
            if (stack.pop() == minStack.peek()){
                 count--;
                if(count == 0){
                   int val = getMin(stack);
                   minStack.push(val);
                }
            }
        }


    }

    public int top() {

        return stack.peek();
    }

    public int min() {

        return minStack.peek();
    }


    //获取栈中最小的元素
    public  int getMin(Stack<Integer> stack){
        int temp = stack.peek();
        if(stack != null){
            Iterator<Integer> iter = stack.iterator();
            while(iter.hasNext()){
                int cur = iter.next();
                if(temp ==cur)
                {count++;}
                temp = temp < cur ?temp:cur;
            }
        }
        return  temp;
    }


    public static void main(String[] args) {
        int min = 0;
        Main_包含Min的桟 s = new Main_包含Min的桟();
        s.push(2);
        min = s.min();
        System.out.println("2入栈后最小值为:"+min);
        s.push(3);
        min = s.min();
        System.out.println("3入栈后最小值为:"+min);
        s.push(4);
        min = s.min();
        System.out.println("4入栈后最小值为:"+min);
        s.push(1);
        min = s.min();
        System.out.println("1入栈后最小值为:"+min);
        System.out.println("此时最小值的count为:"+count);
        s.pop();
        min= s.min();
        System.out.println("1出栈后最小值为:"+ min);
        s.push(1);
        min = s.min();
        System.out.println("1入栈后最小值为:"+min);
        s.pop();
        min= s.min();
        System.out.println("1出栈后最小值为:"+ min);
        System.out.println("count:"+count);
    }

}
