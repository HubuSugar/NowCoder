package com.hubu.swordOffer.week05;

public class Main_1到n的和 {
     //利用异常退出递归
    public int Sum_Solution(int n) {

        int sum = 0;
        try{
            sum = n;
            n--;
            int res = 1 / n;
            sum += Sum_Solution(n);
        }
        catch(Exception e){
            return sum;
        }
        return sum;
    }

    //利用运算符短路与
    public int Sum_Solution1(int n) {

        int sum = n;
        int ano = n--;
        boolean  b = (ano > 0)&&((sum += Sum_Solution1(n)) > 0);
        return sum;

    }

    public static void main(String[] args) {

        int count = new Main_1到n的和().Sum_Solution1(5);
        System.out.println(count);
    }
}
