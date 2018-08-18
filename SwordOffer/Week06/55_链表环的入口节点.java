    /**
     * 让两个指针p1,p2分别从链表的头遍历，其中p1的速度是p2的两倍
     * Sp1 = x + m * a + c
     * Sp2 = x + n * a + c
     * 其中x 为链表头到环的入口结点的距离
     *        a为入口结点到两指针相遇的地方的距离
     *        c为环的距离
     *     2 * (x + n * a + c) =  x + m * a + c  -->  x = (n - 2m - 1) c + c - a
     * 可以得出结论，两个指针相遇的地方到环的入口结点与链表头到环的入口结点距离相等
     * */
package com.hubu.swordOffer.week06;

import com.hubu.util.ListNode;

public class Main_链表环的入口节点 {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
       //至少三个结点构成环
        if(pHead == null || pHead.next ==null ||pHead.next.next ==null) return null;
        ListNode p1 = pHead.next.next;
        ListNode p2 = pHead.next;
        while(p1 !=  p2){

           if(p1.next != null&& p1.next.next != null){
               p2 = p2.next;
               p1 = p1.next.next;
           }else{
               return null;
           }

        }
        //如果循环可以出来说明有环
        p1 = pHead;
        while(p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
        }
        return p1;

    }

    public static void main(String[] args) {
        //链表的头结点
        ListNode pHead = new ListNode(1);
        ListNode t = new Main_链表环的入口节点().EntryNodeOfLoop(pHead);
        System.out.println(t);

    }

}
