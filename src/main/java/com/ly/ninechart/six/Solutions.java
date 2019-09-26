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

    public static Node head ;
    public static Node middle ;
    static {
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node middle = new Node(9,node4);
        Node node2 = new Node(3,middle);
        Node node1 = new Node(2,node2);
         head = new Node(1,node1);
    }

    public static Node removeDuplicatesFromSortedList(Node head) {
        if( head == null) {
            return null;
        }

        Node prev = new Node(0,head);
        head = prev;
        while (head.next.next != null) {
            if( head.next.value.equals(head.next.next.value)) {
                Node data = head.next;
                while (data.next != null && data.next.value.equals(data.value)) {
                    data = data.next;
                }
                head.next = data.next;
            } else  {
              head = head.next;
            }

        }

        return prev.next;
    }


    /**
     * 根据提供的头节点实现指定位置反转链表
     * @param head
     * @param n
     * @param m
     * @return
     */
    public static Node reverseRange(Node head,int n,int m  ) {
        if( head == null) {
            return null;
        }

        int i = 1;
        while (head != null) {

        }

        return null;
    }


    public static void deleteNodeFromMiddle(Node node) {
        if(node == null) {
            return;
        }

        node.value = node.next.value;
        node.next = node.next.next;
    }

    // 反转
    public static Node reverse(Node head) {

        if(head == null) {
            return null;
        }

        Node prev = null;
        while (head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;

    }

    public static void main(String[] args) {
        //System.out.println(removeDuplicatesFromSortedList(head));

//        System.out.println(head);
//        deleteNodeFromMiddle(middle);
//        System.out.println(head);

        System.out.println(reverse(head));;
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
