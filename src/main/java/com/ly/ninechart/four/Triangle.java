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
            f[i][0] = triangle[i][0] + f[i][0];
            f[i][i] = triangle[i][i] + f[i-1][i-1];
        }

        for(int j = 1;j < n; j ++) {
            for (int i = 1; i < j; i++) {
                f[j][i] = triangle[j][i] + Math.min( f[j-1][i-1], f[j-1][i]);
            }
        }

       // return Math.max(...);

        return  -1;
    }

    /**
     *  n * m  的 二维数组 求最小路径
     * @param grid
     * @return
     */
    public static int minPathSum(int [][] grid) {

        if( grid == null || grid.length == 0 || grid[0].length == 0) {
            return Integer.MAX_VALUE;
        }

        int n = grid.length;
        int m = grid[0].length;
        // f[i][j] 代表从起点 grid[0][0] 到 grid[i][j]的最短路径
        int [][] f = new int[n][m];
        // 初始化 f[0][j] 和  f[i][0]
        f[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = grid[i][0] + f[i-1][0];
        }

        for (int i = 1; i <m; i++) {
            f[0][i] = grid[0][i] + f[0][i-1];
        }

        for (int i = 1; i < n ; i++) {
            for (int j =1; j < m ; j++) {
                f[i][j] = grid[i][j]+ Math.min(f[i-1][j],f[i][j-1]);
            }
        }

        return f[n-1][m-1];

    }


    /**
     * 给定一个二维数组 n*m 求可能的路径
     * @return
     */
    public static int uniquePath(int n , int m ) {
        if( n == 0 || m == 0 ) {
            return -1;
        }
        // f[i][j] 代表 数组a[0][0] 到 f[i][j]可能的方案
        int [][] f = new int [n][m];

        for (int i = 0; i < n; i++) {
            f[i][0] = 1;
        }
         for (int i = 0; i < m; i++) {
            f[0][i] = 1;
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < m ; j++) {
                f[i][j] = f [i-1][j] + f[i][j-1];
            }
        }

        return f[n-1][m-1];
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以向后跳跃的最大长度。
     * @param arrays
     * @return
     */
    public static boolean jumpGame(int [] arrays) {
        if ( arrays == null || arrays.length == 0 ) {
            return false;
        }
        // f[i] 表示是否可以到达 arrays[i];
        boolean[] f = new boolean[arrays.length];
        f[0] = true;
        for (int i = 1; i < arrays.length; i++) {
            for (int j = 0; j < i; j++) {
                if(f[j]) {
                    if(j + arrays [j] >= i) {
                        f[i] = true;
                        break;
                    }
                }
            }
        }
        return f[arrays.length -1];

    }

    /**
     * 求最少步骤
     * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以向后跳跃的最大长度。
     * @param arrays
     * @return
     */
    public static boolean jumpGame2(int [] arrays) {
        if ( arrays == null || arrays.length == 0 ) {
            return false;
        }
        // f[i] 表示是否可以到达 arrays[i];
        boolean[] f = new boolean[arrays.length];
        f[0] = true;
        for (int i = 1; i < arrays.length; i++) {
            for (int j = 0; j < i; j++) {
                if(f[j]) {
                    if(j + arrays [j] >= i) {
                        f[i] = true;
                        break;
                    }
                }
            }
        }
        return f[arrays.length -1];

    }

    /**
     * 查询一个数组的最大的上升数组的长度
     * @param arrays
     * @return
     */
    public static int lct(int[] arrays) {
        if( arrays == null || arrays.length == 0) {
            return Integer.MIN_VALUE;
        }
        // f[i] 表示 以 arrays[i] 为结尾的最大上升序列的数组长度
        int[] f = new int[arrays.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length ; i++) {
            f[i] = 1; 
            for (int j = 0; j < i; j++) {

                if( arrays [j] <= arrays [i]) {
                    f[i] = f[j] +1 > f[i] ? f[j] +1 : f[i];
                }
            }
            if( f[i] > max) {
                max = f[i];
            }
        }

        return max;

    }



    public static void main(String[] args) {
        int [][] triangle =new int[3][];

        int[] arr1 = {2};
        int[] arr2 = {3,4};
        int[] arr3 = {5,6,7};
        triangle[0] = arr1;
        triangle[1] = arr2;
        triangle[2] = arr3;


        int [][] A =new int[3][];

        int[] a1 = {1,2,4};
        int[] a2 = {3,4,5};
        int[] a3 = {5,6,7};
        A[0] = a1;
        A[1] = a2;
        A[2] = a3;



        int [][] hash = { {Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}};
        System.out.println(traverse(triangle));
        System.out.println(divideConquer(triangle));
       // System.out.println(fromBottomToTop(triangle));
        System.out.println(minPathSum(A));
        System.out.println(uniquePath(4,4));

        System.out.println(jumpGame(new int []{1,1,0,4}));
        System.out.println(jumpGame(new int []{1,4,0,4}));
        System.out.println(lct(new int []{1,4,0,4,5,1,7,8}));
    }




}
