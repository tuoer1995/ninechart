package com.ly.ninechart.three;

/**
 * TODO
 *
 * @author tuoer
 * @date 2019/9/14 18:30
 */
public class CommonNodeService {

    public static TreeNode commonNode(TreeNode root,TreeNode node1,TreeNode node2) {
        if( root == null || root == node1 || root == node2 ) {
            return root;
        }

        TreeNode lNode = commonNode ( root.left , node1 , node2 );
        TreeNode rNode = commonNode ( root.right,node1,node2 );

        if ( lNode != null && rNode != null ) {
            return root;
        }

        if ( lNode != null ) {
            return lNode;
        }
        if( rNode != null ) {
            return rNode;
        }

        return null;
    }
}
