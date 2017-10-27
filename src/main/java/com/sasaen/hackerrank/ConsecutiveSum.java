package com.sasaen.hackerrank;

import java.util.stream.IntStream;

/**
 * Given a number N, return all the combinations of consecutive number that sum N.
 * For example:
 * N=15 result= 3:
 * 1+2+3+4+5
 * 4+5+6
 * 7+8
 */
public class ConsecutiveSum {

    static int consecutiveCombination(int target, int currentIndex) {
        int currentSum = 0;
        for (int i = currentIndex; i < target - 1; i++) {
            currentSum += i;
            if (currentSum == target) {
                System.out.print("\nSolution: ");
                IntStream.range(currentIndex, i).forEach(element -> System.out.print(element+" "));
                return 1;
            } else if (currentSum > target) {
                return 0;
            }
        }
        return 0;
    }

    static int consecutive(int num) {
        int found = 0;
        for (int i = 0; i < num; i++) {
            found = found + consecutiveCombination(num, i + 1);
        }

        return found;
    }

    public static void main(String[] args) {
        System.out.println(consecutive(15));
    }
}
