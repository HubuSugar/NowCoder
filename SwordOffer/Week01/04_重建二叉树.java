 //递归思想:前序遍历的第一个结点是根，通过根节点将中序结果分为左子树和右子树
package com.hubu.swordOffer.week01;

import com.hubu.util.TreeNode;

public class Main_重建二叉树 {
   
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre == null || in == null) return  null;

        //根节点始终为先序遍历的第一个结点
        TreeNode root = new TreeNode(pre[0]);
        //数组长度
        int len = pre.length;

        if(len == 1){
            return root;
        }

        //找到先序的根节点在中序遍历中的位置
        int i;
        for(i = 0;i < in.length;i++){
            if(pre[0] == in[i]){
                break;
            }
        }
        
        int[]  inChild;    //中序遍历的子树
        int[] preChild;   //先序遍历的子树
        //根节点在中序遍历数组的的位置不是第一个
        if(i > 0){
            //中序遍历的左子树
            inChild = new int[i];
            preChild = new int[i];
            for (int j = 0; j < i ; j++) {
                inChild[j] = in[j];
                preChild[j] = pre[j + 1];
            }
            //构建左子树
            root.left = reConstructBinaryTree(preChild,inChild);
        }
        else{
            root.left = null;
        }
        //根节点不是中序遍历的最后一个结点
        if(i < len-1){
            inChild = new int[len - 1 -i];
            preChild = new int[len - 1 -i];
            for (int j = i + 1; j < len ; j++) {
                inChild[j - i - 1] = in[j];
                preChild[j - i -1] = pre[j];
            }
            root.right = reConstructBinaryTree(preChild,inChild);

        }else{
            root.right = null;
        }
        return root;
    }
   //测试
    public  static void  main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};   
        int[] in = {4,7,2,1,5,3,8,6}; 
        TreeNode tn = new Main_重建二叉树().reConstructBinaryTree(pre,in);
        System.out.println(tn);
    }
}
