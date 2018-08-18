//利用归并排序的思想
package com.hubu.swordOffer.week04;

public class Main_数组中的逆序对{

    public int InversePairs(int [] array) {

        if (array == null||array.length == 0) return 0;
        int len = array.length;
        int[]  copy = new int[len];

        for(int i = 0; i < len; i++){
            copy[i] = array[i];
        }

        return InversePairsCore(array,copy,0,len -1);
    }


    private int InversePairsCore(int[] array,int[] copy,int low,int high){

         if(low == high){ return 0;}
         int mid = (low + high) >> 1;
         int leftCount = InversePairsCore(array, copy, low,mid);
         int rightCount = InversePairsCore(array,copy,mid + 1,high);
         int count = 0;
         int i = mid;
         int j = high;
         int locCopy = high;
         while(i >= low && j > mid){
             if(array[i] > array[j]){
                 count += j - mid;
                 copy[locCopy--] = array[i--];
                 if(count >=1000000007){
                     count = count % 1000000007;
                 }
             }
             else{
                 copy[locCopy--] = array[j--];
             }
         }

         for(;i >= low;i--){
             copy[locCopy--] = array[i];
         }
         for(;j > mid;j--){
             copy[locCopy--] = array[j];
         }
         for(int s = low;s <= high;s++){
             array[s] = copy[s];
         }

         return  (leftCount + rightCount + count) % 1000000007;
    }

    public static void main(String[] args) {
       int[]  array = {1,2,3,4,5,6,7,0};
       int res = new S35().InversePairs(array);
        System.out.println(res);
    }


}
