//思路：先确定合成后链表的表头,然后比较两个链表的头结点，小的就拼到链表的后面
package com.hubu.swordOffer.week02;

import com.hubu.util.ListNode;
import com.hubu.util.ListNodeFactory;

public class Main_合并排序链表{

    public ListNode Merge(ListNode list1, ListNode list2) {

       if(list1 == null) return list2;
       if(list2 == null) return list1;

       ListNode merHead = null;
       ListNode cur;
       if(list1.val > list2.val){
           merHead = list2;
           list2 = list2.next;
       }else{
           merHead = list1;
           list1 = list1.next;
       }
      //cur表示当前值较小的结点
       cur = merHead;

       while(list1 != null && list2 != null)
       {
           if(list1.val >= list2.val){
               cur.next = list2;
               list2 = list2.next;
               //当前结点后移一位
               cur =   cur.next;

           }else{
               cur.next = list1;
               list1 = list1.next;
               cur =   cur.next;
           }

       }
       if(list1 == null){cur.next = list2;}
       if(list2 == null){cur.next = list1;}
       return  merHead;
    }

    public static  void main(String[] args){

        String s1 = "1 3 5";
        String s2 = "2 4 6";
        ListNode list1 = ListNodeFactory.ListNodeBuilder(s1);
        ListNode list2 = ListNodeFactory.ListNodeBuilder(s2);
        ListNode head = new Main_合并排序链表().Merge(list1,list2);
        System.out.println(head);
    }

}
