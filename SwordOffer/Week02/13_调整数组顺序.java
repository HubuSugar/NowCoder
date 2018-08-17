//思路:每次遇到一个奇数就会有一个数的位置确定，开始交换的开始位置就需要加1,而交换的结束位置则是i，即遍历到的当前奇数的地方。这样依次交换就能按要求排序
package com.hubu.swordOffer.week02;

public class Main_调整数组顺序{
    public void reOrderArray(int [] array) {

        if(array == null)  return;
        int len = array.length;
        int k = 0;    //定义k来记录每次交换开始的位置
        for (int i = 0; i <len ; i++) {
            //如果遇到奇数就开始交换
           if(array[i] % 2 == 1){
               for(int j = i; j  > k; j--){
                      int temp = array[j- 1];
                      array[j -1] = array[j];
                      array[j] = temp;
               }
               k++;
           }
        }

    }

    public  static  void main(String[] args){
        int[] array = {1,2,3,4,4,5,6};
        new Main_调整数组顺序().reOrderArray(array);
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i]);
        }

    }
}
