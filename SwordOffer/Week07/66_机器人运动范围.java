//思路:需要定义一个矩阵统计每一个方格是否已经计算过，如果计算过那么返回0
package com.hubu.swordOffer.week07;

public class Main_机器人运动范围{

      //计算每个数的数位之和
    private  int sum(int num){
        int res = 0;
        while(num  > 0){
           res += num % 10;
           num = num /  10;
        }
        return  res;
    }
    public int movingCount(int threshold, int rows, int cols)
    {
        //记录是否已经走过
       boolean[][] flag = new boolean[rows][cols];
       for(int i= 0;i < rows;i++){
           for(int j = 0;j < cols;j++){
               flag[i][j] = true;
           }
       }
       return helper(0,0,rows,cols,threshold,flag);
    }

    private int helper(int curx, int cury, int rows, int cols, int threshold, boolean[][] flag) {
        int sum = sum(curx) + sum(cury);
        //如果是不满足条件那么计为0
        if(curx < 0|| curx >= rows || cury < 0|| cury >= cols|| sum >threshold|| !flag[curx][cury])
          return 0;
        flag[curx][cury] = false;
        return  helper(curx + 1,cury,rows,cols,threshold,flag)+
                 helper(curx -1,cury,rows,cols,threshold,flag)+
                helper(curx,cury + 1,rows,cols,threshold,flag)+
                helper(curx,cury - 1,rows,cols,threshold,flag) + 1;
    }

    public static void main(String[] args) {

        int count = new Main_机器人运动范围().movingCount(18,30,30);
        System.out.println(count);
    }


}
