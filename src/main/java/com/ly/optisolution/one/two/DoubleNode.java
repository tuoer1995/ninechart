package com.ly.optisolution.one.two;

/**
 * description:TODO
 *
 * @author: tuoer
 * @date： 2019/9/29
 */
public class DoubleNode {
    int value;
    DoubleNode next;
    DoubleNode last;

    public DoubleNode(int value, DoubleNode next, DoubleNode last) {
        this.value = value;
        this.next = next;
        this.last = last;
    }
}
