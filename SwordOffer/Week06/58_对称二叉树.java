//思路:递归对比根节点的左子树和右子树，然后对比左子树的右子树和右子树的左子树相同即可
package com.hubu.swordOffer.week06;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

public class Main_对称二叉树{

     boolean isSymmetrical(TreeNode pRoot)
     {
        if(pRoot == null)  return true;
           return helper(pRoot.left,pRoot.right);
     }

    boolean helper(TreeNode pLeft,TreeNode pRight){
         if(pLeft == null)  return pRight == null;
         if(pRight == null) return false;
         if(pLeft.val != pRight.val)  return false;
         return helper(pLeft.left,pRight.right)&&helper(pLeft.right,pRight.left);
    }

    public static void main(String[] args) {
       String treeStr = "1,2,#,4,#,#,2,4,5,#,#,#,#";
       TreeNode root = TreeNodeFactory.buildBinaryTreeByDeserialize(treeStr);
       System.out.println(root);
       boolean b =new S58().isSymmetrical(root);
       System.out.println(b);

    }


}
