package com.ly.ninechart.two;

/**
 * 二分法摸板
 *
 * @author tuoer
 * @date 2019/9/9 23:11
 */
public class BinarySearch {
    public static int search(int [] arrays,int target) {
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arrays.length - 1;
        int mid = 0;
        while (start + 1 < end ) {
            mid = start + (end - start)/2;
            if(arrays[mid] < target) {
                start = mid ;
            }else if (arrays[mid] == target)  {
                start = mid;
            }else {
                end = mid;
            }
        }

        if ( arrays[end] == target ) {
            return end;
        }

        if(arrays[start] == target ) {
            return start;
        }

        return -1;
    }

    public static void main( String[] args ) {
        int [] arrays = {1,2,2,2};
        System.out.println (search ( arrays, 2 ));
    }
}
