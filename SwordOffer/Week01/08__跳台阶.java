//思路：一级台阶 1种，2:2种，3:3种，45种，还是满足斐波那契数列的特征；用迭代的方式，因为只能跳一到两步，所以肯定是从n-1或者n-2级台阶跳上来的
package com.hubu.swordOffer.week01;

public class Main_跳台阶{

    public int JumpFloor(int target) {
        if(target <= 0) return -1;
        if(target == 1|| target == 2) return target;
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= target ; i++) {
            third = first + second;
             first = second;   //从第三级台阶时为前两级台阶方式之和
             second = third;    //将第二级的总数赋值给第一级，第三级的总是赋值给第二级
        }
        return third;
    }
    
    //测试
    public static void main(String[] args){
        int m =  new Main_跳台阶().JumpFloor(5);
        System.out.println(m);
    }
}
