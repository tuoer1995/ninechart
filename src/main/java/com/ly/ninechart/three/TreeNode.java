package com.ly.ninechart.three;
import lombok.Data;

import	java.text.DateFormat;

/**
 * description:二叉树节点
 *
 * @author: tuoer
 * @date： 2019/9/12
 */
@Data
public class TreeNode {
    public Integer value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    static TreeNode root ;
    static {
        TreeNode a1 = new TreeNode(5,null,null);
        TreeNode a2 = new TreeNode(11,null,null);
        TreeNode a3 = new TreeNode(13,null,null);
        TreeNode a4 = new TreeNode(22,null,null);
        TreeNode a5 = new TreeNode(32,null,null);
        TreeNode a6 = new TreeNode(12,a2,a3);
        TreeNode a7 = new TreeNode(10,a1,a6);
        TreeNode a8 = new TreeNode(30,a4,a5);
        root = new TreeNode(20,a7,a8);
    }
}
