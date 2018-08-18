 //假设有n个数的和满足要求  如果第一个数为X，那么后续的n个数可以概括为 X+1，X+2..........X+ n -1 
 //则 sum = X + X + 1 + X + 2....+ X + n - 1  = n . X + n(n - 1) /2
 package com.hubu.swordOffer.week05;

import java.util.ArrayList;

public class Main_连续正数序列 {

    public  int getFromOneToN(int n){
        //计算从1 + 2 + ...+ n- 1
        if(n <= 1) return 0;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
               sum += i + 1;
        }
        return sum;
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        if(sum <= 0) return res;
        for (int n = sum - 1; n >= 2; n--) {
            ArrayList<Integer>  oneRes = new ArrayList<>();
            int temp = sum - getFromOneToN(n);
            if(temp > 0){
                if(temp % n == 0){
                    int base = temp / n;
                    for(int i = 0; i < n;i++){
                        oneRes.add(base + i);
                    }
                    if (!res.contains(oneRes)){
                        res.add(new ArrayList<>(oneRes));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res =  new Main_连续正数序列().FindContinuousSequence(100);
        System.out.println(res);
    }

}
