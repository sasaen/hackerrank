package com.sasaen.hackerrank;

import java.util.stream.IntStream;

/**
 * Prints the Fibonacci sequence for a given number
 */
public class Fibonacci {

    static int fibonacci(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    static void printFibonacciSequence(int number) {
        IntStream.range(0, number).forEach(i -> System.out.print(fibonacci(i) + " "));
    }

    public static void main(String[] args) {
        printFibonacciSequence(10);
    }
}
