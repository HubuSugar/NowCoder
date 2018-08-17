//思路:关键是将数组排好序，取前k个数字即可,集合中带比较器的TreeSet和队列中的可以指定容量和比较器的PriorityQueue，然后取前k个元素即可
package com.hubu.swordOffer.week03;

import java.util.*;

public class Main_最小的K个数{

    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(input == null) return res;
        int len = input.length;
        if(k > len||len == 0) return res;
        TreeSet<Integer>  set = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
       for(int i = 0;i < len;i++){
           set.add(input[i]);
       }
       for(int i = 0;i < k;i++){
            res.add(set.pollLast());
       }
        return res;
    }

    //做法二:使用优先级队列,这个队列采用堆排序
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

         ArrayList<Integer> res = new ArrayList<Integer>();
         if(input == null) return res;
         int len = input.length;
         if(k > len||len == 0) return res;

         PriorityQueue<Integer>  maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
         });

        for(int i=0;i < len;i++){
            if(maxHeap.size() != k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek() > input[i]){
                  maxHeap.poll();
                  maxHeap.offer(input[i]);
            }
        }

        for (Integer integer:maxHeap){
            res.add(integer);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = new Main_最小的K个数().GetLeastNumbers_Solution1(input,4);
        System.out.println(list);
    }
}
