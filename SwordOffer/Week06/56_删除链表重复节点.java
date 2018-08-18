//思路:创建一个头结点，在第二层循环中需要判断当前结点和后一个节点的值是否重复
package com.hubu.swordOffer.week06;

import com.hubu.util.ListNode;
import com.hubu.util.ListNodeFactory;

public class Main_删除链表重复节点{

    public ListNode deleteDuplication(ListNode pHead)
    {
              if(pHead == null || pHead.next == null)  return null;
             //新建头结点
              ListNode head = new ListNode(-1);
              head.next = pHead;
              ListNode pre = head;
              ListNode cur = pHead;
              ListNode aft = null;

              while(cur != null && cur.next != null){
                  aft = cur.next;
                 //先要判断当前结点是否与后面的结点的值相等
                  if(cur.val == aft.val){
                      while(aft != null && cur.val == aft.val){
                                aft = aft.next;
                      }
                      pre.next = aft;
                      cur = aft;
                  }else{
                        pre = cur;
                        cur = cur.next;
                  }
             }
              return head.next;
      }

    public static void main(String[] args) {

       String s2 = "2 2 2 3 3 4 5 6 6";
        ListNode  pHead =  ListNodeFactory.ListNodeBuilder(s2);
        ListNode res = new Main_删除链表重复节点().deleteDuplication(pHead);
        System.out.println(res);

    }


}
