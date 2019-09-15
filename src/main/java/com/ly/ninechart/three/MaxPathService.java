package com.ly.ninechart.three;

import lombok.Data;

/**
 * 最长路径
 *
 * @author tuoer
 * @date 2019/9/15 19:23
 */
public class MaxPathService {
    public static int maxPathSum1(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int lPath = maxPathSum1 ( root.left );
        int rPath = maxPathSum1 ( root.right );


        return root.value +Math.max ( 0,Math.max ( lPath , rPath )  );

    }



    public static int maxPathSum2(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int lPath = maxPathSum1 ( root.left );
        int rPath = maxPathSum1 ( root.right );


        return root.value +Math.max ( 0,lPath ) + Math.max ( 0,rPath );

    }



    public static int maxPathSum3(TreeNode root) {
        return helper(root).maxPath;
    }

    private static ResultType helper(TreeNode node) {
        if( node == null) {
            return new ResultType ( 0,Integer.MIN_VALUE );
        }

        ResultType lh = helper ( node.left );
        ResultType rh = helper ( node.right );

        int singlePathMax = Math.max ( 0,Math.max ( lh.singlePath,rh.singlePath ) + node.value );
        int maxPathMax = Math.max ( Math.max ( lh.maxPath,rh.maxPath ),lh.singlePath+rh.singlePath + node.value );

        return new ResultType ( singlePathMax,maxPathMax );


    }

    public static void main( String[] args ) {
        System.out.println (maxPathSum1 ( TreeNode.root ));
        System.out.println (maxPathSum2 ( TreeNode.root ));
        System.out.println (maxPathSum3 (  TreeNode.root ) );
    }


    @Data
    private static class ResultType {
        /**
         * 从根节点 到任一节点的最大距离
         */
        private int singlePath;
        /**
         * 从任一节点到任意节点的最大距离，至少包含一个点
         */
        private int maxPath;

        public ResultType( int singlePath , int maxPath ) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }


}


