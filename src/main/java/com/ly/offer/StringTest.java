package com.ly.offer;

/**
 * description:TODO
 *
 * @author: tuoer
 * @date： 2019/10/8
 */
public class StringTest {

    public void swap (String aa) {
        aa = "bb";
    }

    public int myAtoi(String str) {
        if( str == null || str.trim().length() == 0 ) {
            return 0;
        }

        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        if(str.charAt(0) == '-') {
            flag = false;
        }else if(str.charAt(0) == '+') {
            flag = true;
        }else if(str.charAt(0) >='1' && str.charAt(0) <='9') {
            flag = true;
            sb.append(str.charAt(0));
        }else {
            return 0;
        }


        for( int i = 1; i < str.length(); i++ ) {
            if( str.charAt(i) >='0' && str.charAt(i) <='9') {
                sb.append(str.charAt(i));
            }else {
                break;
            }
        }

        if( sb.length() == 0) {
            return 0;
        }

        str = sb.toString();
        int result   = 0;

        for(int i = 0; i < str.length(); i++ ) {

            result = result * 10 + str.charAt(i) - '0';
            if(result > Integer.MAX_VALUE / 10) {
                if(flag) {
                    return  Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }

        }

        return flag ? result : result * (-1);

    }

    public static void main(String[] args) {
        String aa = new String("aa");
        StringTest stringTest = new StringTest();
        stringTest.swap(aa);
        System.out.println(aa);
        System.out.println(stringTest.myAtoi(" -43"));
    }
}
