package com.ly.optisolution.one.two;

/**
 * description:打印两个有序链表的公共部分（指的是值相等的部分）
 *
 * 因为节点有序  可以从小往大查询
 *
 * @author: tuoer
 * @date： 2019/9/29
 */
public class Solution1 {

    public void printCommonPart(Node head1,Node head2) {
        if( head1 == null || head2 == null ) {
            return;
        }

        while (head1 != null && head2 != null) {
            if(head1.value < head2.value) {
                head1 = head1.next;
            }else if(head1.value > head2.value) {
                head2 = head2.next;
            }else  {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }


    }
}
