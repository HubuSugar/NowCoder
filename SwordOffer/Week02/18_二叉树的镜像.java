//思路：依次交换根结点的左右子树
package com.hubu.swordOffer.week02;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

public class Main_二叉树的镜像{

    public void Mirror(TreeNode root) {

     if(root == null) return;
     //定义一个临时结点,用作左子树和右子树交换时的临时存储
     TreeNode temp;
     if(root != null){
         temp = root.left;
         root.left = root.right;
         root.right = temp;
         Mirror(root.left);
         Mirror(root.right);
     }
    }

    public static void main(String[] args) {

        String str = "1,2,4,#,#,5,#,#,3,#,#";
        TreeNode root = TreeNodeFactory.buildBinaryTreeByDeserialize(str);

        new Main_二叉树的镜像().Mirror(root);
        System.out.println(root);
    }

}
