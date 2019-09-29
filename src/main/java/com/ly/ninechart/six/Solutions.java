package com.ly.ninechart.six;

import lombok.Data;
import lombok.ToString;

/**
 * description:TODO
 *
 * @author: tuoer
 * @date： 2019/9/25
 */
public class Solutions {

    public static Node head;
    public static Node middle;

    static {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node middle = new Node(9, node4);
        Node node2 = new Node(3, middle);
        Node node1 = new Node(2, node2);
        head = new Node(1, node1);
    }

    public static Node removeDuplicatesFromSortedList(Node head) {
        if (head == null) {
            return null;
        }

        Node prev = new Node(0, head);
        head = prev;
        while (head.next.next != null) {
            if (head.next.value.equals(head.next.next.value)) {
                Node data = head.next;
                while (data.next != null && data.next.value.equals(data.value)) {
                    data = data.next;
                }
                head.next = data.next;
            } else {
                head = head.next;
            }

        }

        return prev.next;
    }


    /**
     * 根据提供的头节点实现指定位置反转链表
     * 思路  : 找到 from - 1 和 to + 1 的位置  看是否满足   1<=from<=to<=length 否则不用调整
     * 先反转 from 至 to的链表  然后  连接 from -1 和  to + 1
     * *
     * @param head
     * @param from
     * @param to
     * @return
     */
    public static Node reverseRange(Node head, int from, int to) {
        int i = 1;
        Node fPrev = null;
        Node tPos = null;
        Node node1 = head;
        while ( node1 != null ) {
            fPrev = from - 1 == i ? head : fPrev;
            tPos = to + 1 == i ? head : tPos;
            node1 = node1.next;
            i++;
        }
        if ( from > to || to > i || from < 1) {
            return head;
        }

        node1 = fPrev == null ? head : fPrev.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next ;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

      if( fPrev != null) {
            fPrev.next = node1;
            return head;
      }
      return node1;
    }


    public static void deleteNodeFromMiddle(Node node) {
        if (node == null) {
            return;
        }

        node.value = node.next.value;
        node.next = node.next.next;
    }

    // 反转
    public static Node reverse(Node head) {

        if (head == null) {
            return null;
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


    /**
     * 双向链表的反转
     * @param head
     * @return
     */
    public static DoubleNode reverse(DoubleNode head) {

        DoubleNode prev = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.last = next;
            head.next = prev;
            prev =head;
            head =next;
        }

        return prev;
    }


    public static void main(String[] args) {
        //System.out.println(removeDuplicatesFromSortedList(head));

//        System.out.println(head);
//        deleteNodeFromMiddle(middle);
//        System.out.println(head);

        System.out.println(reverse(head));
        ;
        System.out.println(head);

    }
}

@Data
@ToString
class Node {
    Integer value;
    Node next;

    public Node(Integer value, Node next) {
        this.value = value;
        this.next = next;
    }
}



@Data
@ToString
class DoubleNode {
    Integer value;
    DoubleNode next;
    DoubleNode last;

    public DoubleNode(Integer value, DoubleNode next,DoubleNode last) {
        this.value = value;
        this.next = next;
        this.last = last;
    }
}
