//思路：定义两个指向头结点的指针，让其中一个先走(k - 1)步到达第K个结点，再让另外一个从头结点开始走，
//当第一个指针走到链表末尾时，第二个指针刚好指向链表的倒数第K个结点
package com.hubu.swordOffer.week02;

import com.hubu.util.ListNode;
import com.hubu.util.ListNodeFactory;

public class Main_链表倒数第K结点{

     public ListNode FindKthToTail(ListNode head, int k) {

        if(head == null || k <= 0) return null;
        ListNode p1 = head;
        ListNode p2 = head;
         for (int i =1; i < k; i++) {
              if(p1.next != null){
                  p1 = p1.next;
              }else{
                  return null;
              }
         }
        while(p1.next != null){
             p1 = p1.next;
             p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        String str = "1 2 3   4";
        ListNode head  = ListNodeFactory.ListNodeBuilder(str);
        ListNode res = new  Main_链表倒数第K结点().FindKthToTail(head,1);
        System.out.println(res);

    }
}
