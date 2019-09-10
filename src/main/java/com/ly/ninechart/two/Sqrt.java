package com.ly.ninechart.two;

/**
 * description:TODO
 *
 * @author: tuoer
 * @date： 2019/9/10
 */
public class Sqrt {

    public static int sqrt( int target) {
        if( target <= 0 ) {
            throw new IllegalArgumentException("只支持正整数");
        }

        long start = 0;long end = target;
        while(start + 1L < end) {
            long mid = start + (end - start) /2;
            if(mid*mid < target) {
                start = mid;
            }else if (mid*mid == target) {
                end = mid;
            }else {
                end = mid;
            }
        }

        if(end * end == target) {
            return (int)end;
        }else {
            return  (int)start;
        }

    }

    public static void main(String[] args) {
        System.out.println(sqrt(100000000));
    }
}
