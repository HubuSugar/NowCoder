//三步法
//1.复制链表，A-->B-->C 为 A -->A` -->B --> B` --> C --> C`
//2.复制随机指针random
//3.拆分链表为 A --> B --> C 和 A` --> B` --> C`
package com.hubu.swordOffer.week03;

import com.hubu.util.RandomListNode;

public class Main_复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
         RandomListNode cur = pHead;
       //复制next
         while( cur != null){
               RandomListNode node = new RandomListNode(cur.label);
                node.next =    cur.next;
                cur.next = node;
                cur = node.next;
         }

       //复制random
        cur = pHead;
        while(cur != null){
             if(cur.random != null){
                 cur.next.random = cur.random.next;
             }
             cur = cur.next.next;
        }

        //拆分链表
        RandomListNode head = pHead.next;
        RandomListNode pCur = head;
        cur = pHead;
        while(cur != null){
           cur .next = cur.next.next;
            if(pCur.next!= null){
                pCur.next = pCur.next.next;
            }
            cur = cur.next;
            pCur = pCur.next;
        }
        return  head;

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
