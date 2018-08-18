//思路:从根节点开始递归，当每次遍历到叶子节点的时候，判断当前这条路径的长度与depth的大小，最终的较大值就是这棵树的深度
package com.hubu.swordOffer.week04;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

import java.util.ArrayList;

public class Main_二叉树的深度{

    ArrayList<Integer>  onePath = new ArrayList<>();
    int depth = 0;
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;

        onePath.add(root.val);
        if(root.left == null&& root.right == null){
             depth = depth > onePath.size()?depth:onePath.size();
        }

        if (root.left != null){
            TreeDepth(root.left);
        }
        if (root.right != null){
            TreeDepth(root.right);
        }

        onePath.remove(onePath.size() - 1);

        return depth;
    }

    public static void main(String[] args) {
        TreeNode  tn = TreeNodeFactory.buildBinaryTreeByDeserialize("1,2,4,#,#,5,#,#,3,#,#");
        int dep = new Main_二叉树的深度().TreeDepth(tn);
        System.out.println(dep);
    }


}
