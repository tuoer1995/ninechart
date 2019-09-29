package com.ly.optisolution.one.two;

/**
 * description:反转部分单链表
 *
 * @author: tuoer
 * @date： 2019/9/29
 */
public class Solution5 {

    public Node reversePart(Node head,int n,int m) {
        if(head == null) {
            return null;
        }
        Node cur = head;
        int length = 0;
        Node fPre = null;
        Node tPos = null;
        while (cur != null) {
            ++ length;
            fPre =  n -1  == length ? cur : fPre;
            cur =   m + 1 == length ? cur : tPos;
        }

        if(m > length || n > m || n < 1 ) {
            throw new RuntimeException("不满足反转范围");
        }

        Node node1 = fPre == null? head:fPre.next;
        Node prev = tPos;
        Node next = null;
        while ( node1 != tPos) {
            next = node1.next;
            node1.next = prev;
            prev = node1;
            node1 = next;
        }

        if( prev != head) {
            fPre.next = prev;
        }
        return head;

    }
}
