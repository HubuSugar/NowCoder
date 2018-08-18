//思路:序列化二叉树就是选择遍历方式后（中序，先序，后序）如果按该方式遍历该树，遇到空节点那么返回#
package com.hubu.swordOffer.week07;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

public class Main_序列化二叉树 {

    int index = -1;
    //用先序遍历序列化二叉树
    StringBuilder res = new StringBuilder();
    String Serialize(TreeNode root) {

        if(root == null){
            res.append("#,");
        }else{
            res.append(root.val+",");
            Serialize(root.left);
            Serialize(root.right);
        }

        return res.toString();
    }
    
    //按先序遍历反序列化二叉树
    TreeNode Deserialize(String str) {
        index++;
        TreeNode  root =null;
        if(str == null)
              return null;
        String[] strings = str.trim().split(",");
        if(strings == null || index >= strings.length){
            return  null;
        }
        if(!strings[index].equals("#")){
            root = new TreeNode(Integer.parseInt(strings[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }

        return root;
    }

    public static void main(String[] args) {

        String string = "1,2,4,#,#,5,#,#,3,6,#,#,7,#,#";
        TreeNode root = new Main_序列化二叉树().Deserialize(string);
        String res =  new Main_序列化二叉树().Serialize(root);
        System.out.println(res);

    }


}
