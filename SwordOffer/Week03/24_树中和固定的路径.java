package com.hubu.swordOffer.week03;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

import java.util.ArrayList;

public class Main_树中和固定的路径{

    ArrayList<ArrayList<Integer>> allPath = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer>  onePath = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //如果根节点为空，返回空allPath
        if(root == null) return allPath;
        onePath.add(root.val);
        //如果为叶子节点
        if(root.left == null && root.right == null){
            if(target == root.val){
                allPath.add(new ArrayList<Integer>(onePath));
            }
        }
        if(root.left != null){
            FindPath(root.left,target - root.val);
        }
        if(root.right != null){
            FindPath(root.right,target - root.val);
        }
        onePath.remove(onePath.size() - 1);
        return allPath;
    }

    public static void main(String[] args) {

        String str = "1,2,4,#,#,6,#,#,3,5,#,#,7,#,#";
        TreeNode root = TreeNodeFactory.buildBinaryTreeByDeserialize(str);
        ArrayList<ArrayList<Integer>> allPath  = new Main_树中和固定的路径().FindPath(root,9);
        System.out.println(allPath);

    }

}
