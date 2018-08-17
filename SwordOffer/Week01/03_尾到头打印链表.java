//思路：先直接从头到尾打印，插入list集合时每次都插入集合的第一位，只是这样每次都要赋值一次集合，占用空间大
//或者用一个栈
package com.hubu.swordOffer.week01;

import com.hubu.util.ListNode;
import java.util.ArrayList;

public class Main_尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       ArrayList<Integer> list = new ArrayList<Integer>();
       if(listNode == null) return list;
       while(listNode != null){
           //当前结点不为空，就添加到list集合的第一位
           list.add(0,listNode.val);
           //将头结点后移一位
           listNode = listNode.next;
       }
        return list;
    }

}
