package com.hubu.swordOffer.week04;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;


public class S39 {

    //计算树的深度
    //对于每一个人结点获取树的深度
     int curDep = 0;
     int maxDep = 0;

    public  int getDep(TreeNode root){

        if (root == null)  return 0;

        curDep++;

        if (root.left == null && root.right == null){
            maxDep = maxDep > curDep? maxDep: curDep;
        }
        if (root.left != null){
            getDep(root.left);
        }
        if (root.right != null){
            getDep(root.right);
        }
        curDep--;
        return maxDep;
    }



    public boolean IsBalanced_Solution(TreeNode root) {
      /*  if (root == null){
            return true;
        }
        depth(root);
        return isBalanced;*/
        if(root == null) return true;
        int dep1 = TreeDepth(root.left);
        int dep2 = TreeDepth(root.right);

        return Math.abs(dep1 - dep2) <= 1
                &&IsBalanced_Solution(root.left)
                &&IsBalanced_Solution(root.right);
    }

    private  boolean isBalanced = true;
    private int depth(TreeNode root){

        if (root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        if(Math.abs(left - right) > 1) isBalanced = false;

        return right > left?right + 1: left+1;
    }
   //求一棵树的深度
    public static int TreeDepth(TreeNode root){
        if(root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        String str = "1,2,4,#,#,5,#,#,3,#,#";
        String str1 = "1,2,4,6,#,#,7,#,#,5,#,#,3,#,#";
        TreeNode  root = TreeNodeFactory.buildBinaryTreeByDeserialize(str);
        boolean b = new S39().IsBalanced_Solution(root);
       // int b = TreeDepth(root);
        System.out.println(b);
    }
}
