package com.ly.optisolution.one.two;

/**
 * description:在单链表和双链表中删除倒数第k个元素
 *
 * @author: tuoer
 * @date： 2019/9/29
 */
public class Solution2 {

    public Node removeLastKthNode(Node head,int k ) {
        if( head == null || k < 1 ) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            k--;
        }

       if( k == 0) {
            head = head.next;
        }else if ( k < 0)  {
            Node node = head;
            while (++k != 0) {
                    node = node.next;
            }
            node.next = node.next.next;
        }
        return head;
    }

}
