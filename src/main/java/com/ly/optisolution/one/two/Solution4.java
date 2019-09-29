package com.ly.optisolution.one.two;

/**
 * description:链表的反转
 *
 * @author: tuoer
 * @date： 2019/9/29
 */
public class Solution4 {

    public Node reverseSingle(Node head) {
        if(head == null) {
            return head;
        }
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public DoubleNode reversDouble(DoubleNode head) {
        if(head == null) {
            return head;
        }
        DoubleNode prev = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            head.last = next;
            prev = head;
            head = next;
        }
        return prev;
    }

}
