package com.samuel.codility.sieveeratosthenes;

import java.util.Arrays;

/**
 * You are given an array A consisting of N integers.
 * <p>
 * For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.
 * <p>
 * For example, consider integer N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * For the following elements:
 * <p>
 * A[0] = 3, the non-divisors are: 2, 6,
 * A[1] = 1, the non-divisors are: 3, 2, 3, 6,
 * A[2] = 2, the non-divisors are: 3, 3, 6,
 * A[3] = 3, the non-divisors are: 2, 6,
 * A[4] = 6, there aren't any non-divisors.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * the function should return [2, 4, 3, 2, 0], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..50,000];
 * each element of array A is an integer within the range [1..2 * N].
 */
public class CountNonDivisible {
    static class Solution {
        public int[] solution(int[] A) {
            int N = A.length;
            int maxValue = 0;
            int[] counter = new int[2 * N + 1];
            for (int num : A) {
                maxValue = Math.max(num, maxValue);
                counter[num]++;
            }

            int[] divisibles = new int[2 * N + 1];
            for (int i = 1; i <= Math.sqrt(maxValue); i++) {
                for (int j = i * i; j <= maxValue; j += i) {
                    divisibles[j] += counter[i];
                    if (j / i != i) divisibles[j] += counter[j / i];
                }
            }

            int[] rtrn = new int[N];
            for (int i = 0; i < N; i++) {
                rtrn[i] = N - divisibles[A[i]];
            }

            return rtrn;
        }
    }

    public static void main(String[] args) {
        // Expected: [2, 4, 3, 2, 0]
        System.out.println(Arrays.toString(new Solution().solution(new int[]{3, 1, 2, 3, 6})));
    }
}
