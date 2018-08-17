package com.hubu.swordOffer.week03;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_上下打印二叉树 {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        //定义一个队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点添加到队列中
        queue.add(root);
        while(!queue.isEmpty()){
            //取出队列的第一个结点
            TreeNode temp = queue.poll();
            list.add(temp.val);
            //如果第一个结点有左孩子，将左孩子添加到队列的末尾
            if(temp.left != null){
                queue.add(temp.left);
            }
            //如果第一个结点有右孩子，将右孩子添加到队列的末尾
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        String str = "1,2,4,#,#,5,#,#,3,6,#,#,7,#,#";
        TreeNode root = TreeNodeFactory.buildBinaryTreeByDeserialize(str);
        ArrayList<Integer> list = new S22().PrintFromTopToBottom(root);
        for (int k:list
             ) {
            System.out.print(k);
        }

    }

}
