package com.hubu.swordOffer.week07;

import java.util.*;

public class Main_数据流的中位数 {

    //用两个堆，一个大顶堆，一个小顶堆来筛选元素

      private  int count = 0;
      private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15,new Comparator<Integer>(){
          @Override
          public int compare(Integer o1, Integer o2) {
              return o2.compareTo(o1);
          }
      });

    public void Insert(Integer num){
        if (count % 2 == 0){
            //当数据总数为偶数时,新加入的元素进入小根堆（注意不是直接进入小根堆，而是经过大根堆筛选后的最大元素进入小根堆）
            //1.元素进入大根堆,
            maxHeap.offer(num);
            int filterMaxNum = maxHeap.poll();
            //从大根堆选出来的最大的元素进入小根堆
            minHeap.offer(filterMaxNum);
        }else {
            //反之，当数据总数为奇数时，元素进入大根堆（同样也是先进入小根堆，经过小根堆筛选的最小元素）
            minHeap.offer(num);
            int filterMinNum =  minHeap.poll();
            maxHeap.offer(filterMinNum);
        }
        count++;
    }

    public Double GetMedian(){
        if(count % 2 == 0){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
           return minHeap.peek() / 1.0;
        }

    }

    public static void main(String[] args) {
        Main_数据流的中位数 ss = new Main_数据流的中位数();
        int[] a = {49,38,65,97,76,13,27,49,55,04};
        for (int i = 0; i <  a.length; i++) {
            ss.Insert(a[i]);
            Double res = ss.GetMedian();
            System.out.println("插入数字"+a[i]+"后，中位数为:"+res);
        }
    }
}
