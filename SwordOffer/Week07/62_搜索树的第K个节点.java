package com.hubu.swordOffer.week07;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

//:二叉排序树在中序遍历下是有序的
public class Main_搜索树的第K个节点 {

    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
       if(pRoot != null){
           TreeNode node = KthNode(pRoot.left,k);
           if(node != null)
                  return node;
            index++;
            if(index == k)
                 return  pRoot;
            node = KthNode(pRoot.right,k);
            if(node != null)
                return node;
       }
        return null;
    }

    public static void main(String[] args) {

        String str = "5,3,2,#,#,4,#,#,7,6,#,#,8,#,#";
        TreeNode pRoot = TreeNodeFactory.buildBinaryTreeByDeserialize(str);
        TreeNode root = new Main_搜索树的第K个节点().KthNode(pRoot,3);
        System.out.println(root);
    }


}
