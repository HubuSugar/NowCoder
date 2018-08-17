//思路:根据元素的最后一个节点(即根节点)确定左右子树,在数组中找到第一个大于根节点的元素，
//该元素左边为其左子树，右边为其右子树，同时如果右边的元素有比其小的，直接返回false，否则递归左右子树
package com.hubu.swordOffer.week03;

public class Main_后序遍历序列{

    public boolean VerifySquenceOfBST(int [] sequence) {
        boolean b1 = true;
        boolean b2 = true;
        if(sequence == null || sequence.length == 0) return  false;
        if(sequence.length == 1 || sequence.length == 2) return true;
        int len = sequence.length;
        //后序遍历的最后一个元素为根节点
        int root = sequence[len - 1];
        int i;
        for(i =0;i < len - 1 ;i++){
            if(sequence[i] > root){
                break;
            }
        }
        for(int j = i;j < len - 1;j++){
            if(sequence[j] < root){
                return  false;
            }
        }
        //创建两个左子树和右子树的数组
        int[]  leftSeq = null;
        int[] rightSeq = null;
        //说明有左子树
        if(i != 0){
            leftSeq = new int[i];
            for(int j = 0;j <i;j++){
                leftSeq[j] = sequence[j];
            }
            b1 = VerifySquenceOfBST(leftSeq);
        }
        //说明有右子树
        if(i  != len - 1){
            rightSeq = new int[len - 1 -i];
            for(int j = i;j < len - 1;j++){
                rightSeq[j - i] = sequence[j];
            }
            b2 = VerifySquenceOfBST(rightSeq);
        }

        return b1 && b2;

    }

    public static void main(String[] args) {

        int[] seq = {4,6,7,5};
        boolean b = new Main_后序遍历序列().VerifySquenceOfBST(seq);
        System.out.println(b);
    }
}
