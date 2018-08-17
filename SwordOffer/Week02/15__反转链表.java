//思路：需要实现这样的形式: 1-->2-->3-->4 反转一次后  1-->2  3-->4,定义两个指针pre,temp 一个记录当前结点的前一个结点，
//一个记录当前结点的后一个节点
//注意：返回值要返回pre,因为循环结束的条件是head为null，所以不能返回head
package com.hubu.swordOffer.week02;

import com.hubu.util.ListNode;
import com.hubu.util.ListNodeFactory;

public class Main_反转链表{

    public ListNode ReverseList(ListNode head) {

        //如果链表为空，则直接返回空
        if(head == null) return null;
        ListNode pre = null;   //用来记录当前结点的前一个结点
        ListNode temp;  //用来记录当前结点的下一个结点，以防链表断开
        while(head != null){
            //首先把当前结点的下一个结点保存下来
            temp = head.next;
            //将pre结点赋值给当前结点的下一个结点，完成反转
            head.next = pre;
            //将当前的结点赋值为其前一个结点pre
            pre = head;
            //将当前结点移动到下一个
            head = temp;
        }
       return pre;
    }


    public static void main(String[] args){

        String str= "1 2 3 4 5";
        ListNode head = ListNodeFactory.ListNodeBuilder(str);
        ListNode res = new Main_反转链表().ReverseList(head);
        System.out.println(res);
    }
}
