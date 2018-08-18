package com.hubu.swordOffer.week04;

public class Main_数字在数组的次数{
    //因为是排好序的数组所以要找到第一个比K小的数，和第一个比K大的数
    public int GetNumberOfK1(int [] array , int k) {
        int count;
        if(array == null ||array.length ==0) return 0;
        int len = array.length;
        int i;
        int j;

        for (i = 0; i < len; i++) {
            if(array[i] == k){
                break;
            }
        }

        for( j = len -1;j>=0;j--){
            if(array[j] == k){
                break;
            }
        }


        if(j ==i){
            count = 1;
        }else if(j < i){
            count = 0;
        }else{
            count = j - i + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array =new int[]{1};
       int count= new Main_数字在数组的次数().GetNumberOfK1(array,2);
        System.out.println(count);
    }


}
