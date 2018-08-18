//思路:定义两个指针last记录上一层的最后一个结点，nlast记录当前正在访问的结点
package com.hubu.swordOffer.week06;

import com.hubu.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_按层打印二叉树 {

    ArrayList<ArrayList<Integer>> allCeil = new ArrayList<>();
    ArrayList<Integer> oneCeil = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if (pRoot == null) return allCeil;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);


        TreeNode last =pRoot;     //表示下一层的最后结点
        TreeNode nlast = null;   //表示当前正在访问的结点


        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            oneCeil.add(tmp.val);

            if (tmp.left != null){
                queue.add(tmp.left);
                nlast =tmp.left;
            }
            if(tmp.right != null){
                queue.add(tmp.right);
                nlast = tmp.right;
            }

            if(tmp == last){

                allCeil.add(new ArrayList<Integer>(oneCeil));
                oneCeil = new ArrayList<>();
                last = nlast;
            }

        }

        return allCeil;
    }

    public static void main(String[] args) {

    }


}
