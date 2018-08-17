//思路一：//矩阵有序，从左下角来看，往左是递增的，往上是递减的
package com.hubu.swordOffer.week01;
public class Main_二维数组的查找{
    //矩阵有序，从左下角来看，往左是递增的，往上是递减的
    public boolean Find(int target, int [][] array){
         if(array == null) return  false;
         //不为null时获取矩阵的最大行,最大列
         int rowCount = array.length;
         int colCount = array[0].length;
         int i,j;
         for(i = rowCount - 1,j = 0;i>=0&&j < colCount;)
         {
             //如果找到target则返回true;
             if(target == array[i][j]){
                 return true;
             }
             if(target < array[i][j]){
                 i--;
                 continue;
             }
             if(target > array[i][j]){
                 j++;
                 continue;
             }
         }
         return false;
    }
   //测试
    public static void main(String[] args){
         int[][] num = new int[][]{
                 {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
         };
         System.out.println(new Main_二维数组的查找().Find(8,num));
    }
}
