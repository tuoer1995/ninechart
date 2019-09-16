package com.ly.optisolution.one;

import java.util.Stack;

/**
 * description:设计一个有getMin功能的栈
 *
 * @author: tuoer
 * @date： 2019/9/16
 */
public class Topic1 {



}
class getMinStack{
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public getMinStack() {
        this.dataStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push( int data) {
        if (minStack.isEmpty()) {
            minStack.push(data);
        }else if (data <= minStack.peek()) {
            minStack.push(data);
        }else {
            minStack.push(minStack.peek());
        }
        dataStack.push(data);
    }

    public int pop() {
        if(dataStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin() {
        if(dataStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return minStack.peek();
    }
}
