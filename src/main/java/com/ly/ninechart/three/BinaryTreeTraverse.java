package com.ly.ninechart.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description:二叉树遍历
 *
 * @author: tuoer
 * @date： 2019/9/12
 */
public class BinaryTreeTraverse {

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public static List<Integer> inOrderUnRecurve(TreeNode root){
        if(root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack();
        List result = new ArrayList();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while ( node  != null ) {
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.value);
            node = pop.right;
        }
        return result;
    }

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public static List<Integer> preOrderUnRecurve(TreeNode root){
        if(root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack();
        List result = new ArrayList();
        stack.push(root);

        while (!stack.isEmpty()) {
           TreeNode pop = stack.pop();
            result.add(pop.value);
            if( pop.right != null) {
                stack.push(pop.right);
            }
            if( pop.left != null) {
                stack.push(pop.left);
            }
        }
        return result;
    }

    /**
     * 非递归实现
     * @param root
     * @return
     */
    public static List<Integer> divideConquer(TreeNode root){
        List<Integer> results = new ArrayList<>();
        if(root == null) {
            return results;
        }

        Integer val = root.value;
        List<Integer> left = divideConquer(root.left);
        List<Integer> right = divideConquer(root.right);

        results.addAll(left);
        results.addAll(right);
        results.add(val);
        return results;
    }



    public static void main(String[] args) {
        final List<Integer> treeNodes = inOrderUnRecurve(TreeNode.root);
        final List<Integer> treeNodes2 = preOrderUnRecurve(TreeNode.root);
        System.out.println(treeNodes);
        System.out.println(treeNodes2);

        System.out.println(divideConquer(TreeNode.root));
    }
}
