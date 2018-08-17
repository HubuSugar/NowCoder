//思路一：当矩阵大于2 * 2 时采用递归的方式，输出外面一圈的值后，里面依旧还是一个二维矩阵
//思路二：两层循环，right,bottom表示矩阵的行和列，每循环一次就减一，left指针和top指针每循环一次就加一
package com.hubu.swordOffer.week02;

import java.util.ArrayList;
import java.util.List;

public class Main_顺时针打印矩阵 {

    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null) return null;
        //矩阵的总行数
        int len = matrix.length;
        //矩阵的总列数
        int col = matrix[0].length;

        if(len >= 1) {
            //第0行的元素
            for (int i = 0; i < col; i++) {
                list.add(matrix[0][i]);
            }
        }
        if(col >= 1) {
            //最后一列的元素
            for (int j = 1; j < len; j++) {
                list.add(matrix[j][col - 1]);
            }
        }
        if(len >= 2) {
            //最后一行的元素
            for (int i = col - 2; i >= 0; i--) {
                list.add(matrix[len - 1][i]);
            }
        }
        if(col >= 2) {
            //第一列的元素
            for (int j = len - 2; j >= 1; j--) {
                list.add(matrix[j][0]);
            }
        }

        if(len > 2&& col >2){
            int[][] arr = new int[len - 2][col -2];
            for(int i = 1;i < len - 1;i++ ){
                for(int j = 1;j < col - 1;j++){
                    arr[i - 1][j - 1] = matrix[i][j];
                }
            }
            printMatrix(arr);
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}
        };

        List<Integer> list = new Main_顺时针打印矩阵().printMatrix(matrix);
        System.out.println(list);

    }
}
