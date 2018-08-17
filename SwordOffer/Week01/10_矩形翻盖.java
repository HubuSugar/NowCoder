//思路：列举每一种矩形的方法总数,同跳台阶
package com.hubu.swordOffer.week01;

public class Main_矩形翻盖{
    public int RectCover(int target) {
        if(target <= 0) return 0;
        if(target == 1||target == 2) return target;
        int first = 1;
        int second = 2;
        int third= 0;
        for(int i= 3;i <= target;i++){
            third = first + second;
            first = second;
            second = third;
        }
                return  third;
    }
}
