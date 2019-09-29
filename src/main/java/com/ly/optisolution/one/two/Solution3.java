package com.ly.optisolution.one.two;

/**
 * description:删除链表的中间节点
 *
 * @author: tuoer
 * @date： 2019/9/29
 */
public class Solution3 {

    public Node removeMidNode(Node head) {
        if( head == null || head.next == null ) {
            return head;
        }

        Node cur = head;
        int length = 0;
        while (cur != null) {
            length ++;
            cur = cur.next;
        }

        int middle = length/2 + 1;
        if( middle == 1) {
            head = head.next;
        }else {
            cur = head;
            while ( -- middle != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;

    }
}
