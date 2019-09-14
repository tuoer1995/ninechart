package com.ly.ninechart.three;

import lombok.Data;

/**
 * 求二叉树的深度
 *
 * @author tuoer
 * @date 2019/9/14 14:52
 */
public class TreeDepth {

    private static  int deepth ;

    /**
     *
     * @param root
     * @return
     */
    public static int deepth(TreeNode root) {
        if ( root == null) {
            return 0;
        }
        int lDeepth = deepth ( root.left );
        int rDeepth = deepth( root.right);

        if( lDeepth == -1 || rDeepth == -1 ||Math.abs ( lDeepth - rDeepth ) > 1) {
            return -1;
        }

        deepth = 1+Math.max ( lDeepth,rDeepth );
        return deepth;
    }



    public static int maxValue(TreeNode root) {
        if( root == null ) {
            return -1;
        }

        int lMax = maxValue ( root.left );
        int rMax = maxValue ( root.right );

        return Math.max ( root.value,Math.max ( lMax,rMax ) );
    }

    /**
     * 左右子树的高度差不能超过一
     * @param root
     * @return
     */
    public static ResultType isBalance(TreeNode root) {
        return helper (  root );
    }

    private static ResultType helper(TreeNode root) {
        if( root == null ) {
            return new ResultType ( true,0 );
        }

        ResultType lResult = helper ( root.left );
        ResultType rResult = helper ( root.right );

        int deepth = Math.max ( lResult.maxDeepth,rResult.maxDeepth ) +1;

        if( !lResult.isBalance || !rResult.isBalance) {
            return new ResultType ( false,deepth);
        }

        if( Math.abs ( lResult.maxDeepth - rResult.maxDeepth ) > 1) {
            return new ResultType ( false,deepth);
        }

        return new ResultType ( true,deepth);

    }

    public static void main( String[] args ) {
        System.out.println (deepth ( TreeNode.root ));
        System.out.println (maxValue ( TreeNode.root ));
        System.out.println (isBalance ( TreeNode.root ));
    }

    @Data
    private static  class ResultType {
        private boolean isBalance;
        private int maxDeepth;
        public ResultType( boolean isBalance , int maxDeepth ) {
            this.isBalance = isBalance;
            this.maxDeepth = maxDeepth;
        }
    }
}
