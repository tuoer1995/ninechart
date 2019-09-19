package com.ly.ninechart.four;

/**
 * description:数字三角形的问题求 顶点 到 底边的最大或者最小的长度
 *        [2]
 *       [3,4]
 *      [5,6,7]
 * @author: tuoer
 * @date： 2019/9/18
 */
public class Triangle {

    private static int best = Integer.MAX_VALUE;
    private static int r  = 0;

    private static int [][] hash = { {Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}};

    /**
     * 求最小值
     * @param triangle
     * @return
     */
    public static int traverse(int [][] triangle) {
        if( triangle == null || triangle.length == 0) {
            return Integer.MAX_VALUE;
        }
        int n = triangle.length;
        int result = 0;
        traverse(0,0,n,result,triangle);
        return best;
    }

    /**
     * 求最小值
     * @param triangle
     * @return
     */
    public static int divideConquer(int [][] triangle) {
        if( triangle == null || triangle.length == 0) {
            return Integer.MAX_VALUE;
        }
        return helper(triangle,0,0,triangle.length);
    }

    private static int helper(int[][] triangle, int i, int j, int length) {
        if( i >= length) {
           return 0;
        }

        if (hash[i][j] != Integer.MAX_VALUE) {
            return hash[i][j];
        }

        hash[i][j] =  triangle[i][j] + Math.min( helper(triangle,i+1,j,length),helper(triangle,i+1,j+1,length));
        return  hash[i][j];
    }


    private static void traverse(int i ,int j,int n, int result,int [][] triangle) {
        if( i >= n ) {
            if (result <= best) {
                best = result;
            }
            return;
        }
        traverse(i+1,j,n,result+triangle[i][j],triangle);
        traverse(i+1,j+1,n,result+triangle[i][j],triangle);
    }

    public static int fromBottomToTop(int [][] triangle) {
        final int n = triangle.length;
        if( triangle == null || n == 0) {
            return Integer.MAX_VALUE;
        }

        // f[i][j] 表示 triangle [i][j] 到底部的最小距离
        int[][] f = new int[n][];

        for (int i = 0; i <triangle[n-1].length ; i++) {
            f[n-1][i] = triangle[n-1][i];
        }
        for(int j = n-2;j >= 0; j --) {
            for (int i = 0; i <=j; i++) {
                f[j][i] = triangle[j][i] + Math.min(f[j+1][i],f[j+1][i+1]);
            }
        }

        return f[0][0];
    }


    public static int fromTopToBottom(int [][] triangle) {
        final int n = triangle.length;
        if( triangle == null || n == 0) {
            return Integer.MAX_VALUE;
        }



        // f[i][j] 表示 triangle [i][j] 自顶向下的最小距离
        int[][] f = new int[n][n];
        for (int i = 0; i <  n; i++) {
            f[0] = new int[]{Integer.MAX_VALUE};
            f[0] = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
            f[0] = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        }

        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = triangle[0][0] + f[i][0];
            f[i][i] = triangle[i][i] + triangle[i-1][i-1];
        }

        for(int j = 1;j < n; j ++) {
            for (int i = 1; i < j; i++) {
                f[j][i] = triangle[j][i] + Math.min( f[j-1][i-1], f[j-1][i]);
            }
        }

       // return Math.max(...);

        return  -1;
    }



    public static void main(String[] args) {
        int [][] triangle =new int[3][];

        int[] arr1 = {2};
        int[] arr2 = {3,4};
        int[] arr3 = {5,6,7};
        triangle[0] = arr1;
        triangle[1] = arr2;
        triangle[2] = arr3;
        int [][] hash = { {Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}};
        System.out.println(traverse(triangle));
        System.out.println(divideConquer(triangle));
        System.out.println(fromBottomToTop(triangle));
    }




}
