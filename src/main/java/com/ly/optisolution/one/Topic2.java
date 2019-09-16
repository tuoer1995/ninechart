package com.ly.optisolution.one;

import java.util.Stack;

/**
 * description:由两个栈实现队列 实现队列的基本操作： add  poll peek
 *
 * @author: tuoer
 * @date： 2019/9/16
 */
public class Topic2 {
}
class StackQueue {
    private Stack<Integer> addStack;
    private Stack<Integer> popStack;

    public StackQueue() {
        addStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int data) {
        addStack.push(data);
    }

    public int pop() {
        if(addStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("stackqueue is empty");
        }
        if( popStack.isEmpty() ) {
            while (!addStack.isEmpty()) {
                popStack.push(addStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if(addStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("stackqueue is empty");
        }
        if( popStack.isEmpty() ) {
            while (!addStack.isEmpty()) {
                popStack.push(addStack.pop());
            }
        }
        return popStack.peek();
    }

}
