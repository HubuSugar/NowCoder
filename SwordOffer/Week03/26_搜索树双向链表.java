//思路:用中序遍历递归树中的结点,一棵先序为"5,3,2,#,#,4,#,#,7,6,#,#,8,#,#"的二叉树，递归步骤为：最左的结点2-->3-->4-->5-->6-->7-->8,
//  每次将根节点的赋值给head的right指针,2.将head结点赋值给root.left指针,将head指针下移
package com.hubu.swordOffer.week03;

import com.hubu.util.TreeNode;
import com.hubu.util.TreeNodeFactory;

public class Main_搜索树双向链表{

    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
         convertHelp(pRootOfTree);
        return realHead;
    }

    private void convertHelp(TreeNode pRootOfTree){
        if(pRootOfTree == null) return;
        convertHelp(pRootOfTree.left);
        if(head == null){
            head = pRootOfTree;
            realHead = pRootOfTree;
        }else{
            //将根节点赋值给头结点的的right指针
            head.right = pRootOfTree;
            //将头结点作为根节点的left指针
            pRootOfTree.left = head;
            //将head结点移动到根节点
            head = pRootOfTree;
        }
        convertHelp(pRootOfTree.right);
    }


    //树的结构被破坏输出不了
    public static void main(String[] args) {
        String str = "5,3,2,#,#,4,#,#,7,6,#,#,8,#,#";
        TreeNode pRootOfTree =  TreeNodeFactory.buildBinaryTreeByDeserialize(str);
        TreeNode head = new Main_搜索树双向链表().Convert(pRootOfTree);
        System.out.println(head);
    }
}
