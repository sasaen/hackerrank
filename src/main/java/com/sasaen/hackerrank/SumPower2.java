package com.sasaen.hackerrank;

/**
 *
 */
public class SumPower2 {

    public static int method(int number) {
        if (number == 0) {
            return 1;
        } else {
            return (int) Math.pow(2, number)+ method(number - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(method(4));
    }
}
