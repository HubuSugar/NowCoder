//思路：用两个栈实现，奇数层的时候从左往右入栈，偶数层的时候从右往左入栈
package com.hubu.swordOffer.week06;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

import java.util.ArrayList;
import java.util.Stack;

public class Main_之字形打印二叉树 {

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
         ArrayList<ArrayList<Integer>> allCeil = new ArrayList<>();
          if(pRoot == null) {return allCeil;}
          Stack<TreeNode> stack1 = new Stack<>();
          stack1.push(pRoot);
          Stack<TreeNode> stack2 = new Stack<>();
          int layer = 1;  //标记层号
         while(!stack1.isEmpty()|| !stack2.isEmpty()){
             if(layer %2 != 0){
                 ArrayList<Integer> temp = new ArrayList<>();
                 while(!stack1.isEmpty()){
                     TreeNode node1 = stack1.pop();
                     temp.add(node1.val);
                     if(node1.left != null) stack2.push(node1.left);
                     if(node1.right != null) stack2.push(node1.right);
                 }
                 if(!temp.isEmpty()){
                     allCeil.add(new ArrayList<Integer>(temp));
                     layer++;
                 }
             }else{
                 ArrayList<Integer> temp = new ArrayList<>();
                 while(!stack2.isEmpty()){
                     TreeNode node2 = stack2.pop();
                     temp.add(node2.val);
                     if(node2.right != null){stack1.push(node2.right);}
                     if(node2.left != null){stack1.push(node2.left);}
                 }
                 if (!temp.isEmpty()){
                     allCeil.add(new ArrayList<Integer>(temp));
                     layer++;
                 }
             }
         }
        return allCeil;
    }


    public static void main(String[] args) {

        String str = "1,2,4,#,#,5,#,#,3,6,#,#,7,#,#";
        TreeNode treeNode = TreeNodeFactory.buildBinaryTreeByDeserialize(str);
        ArrayList<ArrayList<Integer>> list = new S59().Print(treeNode);
        System.out.println(list);
    }

}
