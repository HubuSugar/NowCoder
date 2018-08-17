package com.hubu.swordOffer.week02;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

public class Main_树的子结构 {


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean res = false;
        if(root1 != null && root2 != null)
        {
            if(root1.val == root2.val){
                //如果两个根节点相等，则递归判断跟的左子树和跟的右子树
                res = helper(root1,root2);
            }
            //如果当前结点的值不等于子树的根的结点值，则让当前根节点等于他的左孩子
            if(!res){

             res = HasSubtree(root1.left,root2);

            }
            //否则等于他的右孩子
            if(!res){
              res =  HasSubtree(root1.right,root2);
            }
        }
        return res;
    }

    public  boolean helper(TreeNode root1,TreeNode root2){

        //递归完成的条件就是root2为空
        if(root2 == null){
            return true;
        }
        //如果root1已经遍历完了，root2还没有，返回false
        if(root1 == null){
            return false;
        }
        //如果出现结点的值不等返回false
        if(root1.val != root2.val){
            return  false;
        }
           return helper(root1.left,root2.left)&&helper(root1.right,root2.right);
    }


    public static void main(String[] args) {

        String str = "8,#,8,#,9,#,2,#,5";
        String str2 = "8,#,9,#,2";

        TreeNode root1 = TreeNodeFactory.buildBinaryTreeByDeserialize(str);
        System.out.println(root1);
       //反序列的时候引用的全局变量index,在第二次创建二叉树的时候需要重置
       //TreeNodeFactory.index = -1;
       //  TreeNode root2 = TreeNodeFactory.buildBinaryTreeByDeserialize(str2);
       //  System.out.println(root2);

       // boolean res = new Main_树的子结构().HasSubtree(root1,root2);
       // System.out.println(res);

    }
}
