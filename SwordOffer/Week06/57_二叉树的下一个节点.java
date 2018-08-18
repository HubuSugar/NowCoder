//如果该结点不是根节点
//如果该结点是它的父节点的左子树，那么返回它的父节点，否则继续遍历它的父节点的父节点重复上面的步骤，
// 如果遇到根节点还没有找到，那么返回null
package com.hubu.swordOffer.week06;

public class Main_二叉树的下一个节点 {

    //带父节点的指针
    private   class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }

        public TreeLinkNode(int val,TreeLinkNode left, TreeLinkNode right, TreeLinkNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

        @Override
        public String toString() {
            return "TreeLinkNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //如果这个结点的右子树不为空，那么它的后继结点就是它的右子树的最左结点
        if(pNode == null) return pNode;

        if(pNode.right != null){
            TreeLinkNode tmp = pNode.right;
            while(tmp.left != null){
                tmp = tmp.left;
            }
            return tmp;
        }
        while(pNode.next != null){
            TreeLinkNode tmp = pNode.next;
            if(pNode == tmp.left){
                return tmp;
            }else{
                pNode = tmp;
            }
        }

      return null;
    }

    public static void main(String[] args) {
        TreeLinkNode t1,t2,t3,t4,t5,t6,t7,t8;
    }
}
