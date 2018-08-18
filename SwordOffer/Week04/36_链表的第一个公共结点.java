//思路:先让两个指针同时从链表的头节点开始遍历,当其中一个指针指向该条链表的尾节点时,这两个指针的差距.就是这两个链表之间的差距,
 //此时,让指向尾指针的链表从头遍历到另外一条链表的指针走到链表末尾,然后让这条链表的头指针从头开始遍历,
  // 那么当两个指针相遇时的节点就是要找的公共节点
package com.hubu.swordOffer.week04;

import com.hubu.util.ListNode;
import com.hubu.util.ListNodeFactory;

public class Main_链表的第一个公共结点 { 
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;    //指向链表1的头节点的指针
        ListNode p2 = pHead2;   //指向链表2头节点的指针
        ListNode temp = null;   //指向长链表的开始结点

        //让两个指针从头开始遍历
        while(p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next;
            if(p2 == null){
                p2 = pHead2;  //p2指针还原
                temp = pHead1;
                break;
            }
            if(p1 == null){
                p1 = pHead1;
                temp = pHead2;
                break;
            }
        }

        if(p2 == pHead2){
            while(p1 != null){
                p1 = p1.next;
                temp = temp.next;
            }
            if(p1 == null){
                while(temp != null&&p2 != null){
                    temp = temp.next;
                    p2 = p2.next;
                    if(p2 == temp){
                        return temp;
                    }
                }
            }
        }

        if(p1 == pHead1){
            while(p2 != null){
                p2 = p2.next;
                temp = temp.next;
            }
            if(p2 == null){
                while(temp != null&&p1 != null){
                    temp = temp.next;
                    p1 = p1.next;
                    if(p1 == temp){
                        return temp;
                    }
                }
            }
        }

     return temp;

    }

    public static void main(String[] args) {

         ListNode l4 = new ListNode(4,null);
         ListNode l3 = new ListNode(3,l4);
         ListNode l2 = new ListNode(2,l3);
         ListNode pHead1 = new ListNode(1,l2);
         ListNode t7 = new ListNode(7,null);
         ListNode t6 = new ListNode(6,t7);
         ListNode pHead2 = new ListNode(5,t6);
         ListNode common = new Main_链表的第一个公共结点().FindFirstCommonNode(pHead1,pHead2);
         System.out.println(common);

    }


}
