package com.ly.optisolution.one;

import com.ly.optisolution.Component;

import java.util.Stack;

/**
 * description:仅用递归函数和栈操作逆序一个栈
 *
 * @author: tuoer
 * @date： 2019/9/16
 */
public class Topic3 {

    public static int getAndRemoveLastElement(Stack<Integer> stack ) {
        int result = stack.pop();
        if(stack.isEmpty()) {
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if( stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
      //  System.out.println(getAndRemoveLastElement(Component.stack));
        reverse(Component.stack);
        System.out.println(Component.stack);
    }
}
