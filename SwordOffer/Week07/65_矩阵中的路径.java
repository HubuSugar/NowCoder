//思路：回溯法，对矩阵中每一个小格尝试是否有路径
package com.hubu.swordOffer.week07;

public class Main_矩阵中的路径 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str == null) return true;
        if (matrix == null) return str == null;
        boolean[] flag = new boolean[rows * cols];   //定义一个标记类型的数组判断当前数字是否已经历过
        //将flag全部初始化为true
        for(int i = 0;i < rows * cols;i++){
           flag[i] = true;
        }
      //对每个字符尝试看是否有路径存在
        for (int i = 0; i < rows; i++ ) {
               for(int j = 0;j < cols;j++){
                  if(helper(matrix,i,j,rows,cols,str,0,flag)){
                      return true;
                  }
               }
        }
       return false;
    }

    private boolean helper(char[] matrix,int x,int y,int rows,int cols,char[] str,int strIndex,boolean[] f) {
            int index =  x * cols + y;
            if(x < 0||x >= rows||y < 0 || y >= cols||matrix[index] != str[strIndex]||!f[index])
               return false;
            if(strIndex == str.length - 1) return true;
            f[index] = false;
           if(helper(matrix,x - 1,y,rows,cols,str, strIndex + 1,f)
                   ||helper(matrix,x + 1,y,rows,cols,str, strIndex + 1,f)
                   ||helper(matrix,x,y - 1,rows,cols,str, strIndex + 1,f)
                   ||helper(matrix,x,y + 1,rows,cols,str, strIndex + 1,f))
           { return true;}
           f[index] = true;
           return false;
    }

    public static void main(String[] args) {
        char[]  matrix= {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'b','c','c','e','d'};
        //char[] str = {'a','b','c','b'};
        boolean b = new Main_矩阵中的路径().hasPath(matrix,3,4,str);
        System.out.println(b);


    }

}
