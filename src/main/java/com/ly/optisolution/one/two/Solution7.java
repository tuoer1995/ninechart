package com.ly.optisolution.one.two;

/**
 * description:判断是否有环  求环的入口 以及环长
 *
 * @author: tuoer
 * @date： 2019/9/30
 */
public class Solution7 {

    /**
     * 给定头节点判断单链表是否有环
     * @param head
     * @return
     */
    public boolean isLoop(Node head) {
        if( head == null ) {
            return false;
        }

        Node fast = head;
        Node slow = head;
        boolean isLoop = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                isLoop = true;
                break;
            }
        }
        return isLoop;
    }

    /**
     * 指定头节点 ，获取中环形链表的长度
     * @param head
     * @return
     */
    public int getLoopLength(Node head) {

        if( head == null ) {
            return -1;
        }
        boolean isLoop = false;
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                isLoop = true;
                break;
            }
        }
        if(!isLoop) {
            return -1;
        }
        int length = 1;
        slow = slow.next;
        fast = fast.next.next;
        while (slow != fast) {
            length ++;
            slow = slow.next;
            fast = fast.next.next;
        }
        return length;


    }

    /**
     * 指定头节点 ，返回环形链表的首个节点
     * @param head
     * @return
     */
    public Node getLoopBeginNode(Node head) {
        if ( head == null ) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        boolean isLoop = false;

        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                isLoop = true;
                break;
            }
        }

        if( !isLoop ) {
            return null;
        }

        Node node = head;
        while ( node != slow ) {
            slow = slow.next;
            node = node.next;
        }

        return node;

    }

    public static void main(String[] args) {

    }

}
