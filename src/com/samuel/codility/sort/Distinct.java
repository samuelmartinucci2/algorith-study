package com.samuel.codility.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the number of distinct values in array A.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <p>
 * A[0] = 2    A[1] = 1    A[2] = 1
 * A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class Distinct {
    private static class Solution {
        public int solution(int[] A) {
            Set<Integer> distinctNumbers = new HashSet<>();
            for (int num : A) {
                distinctNumbers.add(num);
            }

            return distinctNumbers.size();
        }

        public int solution2(int[] A) {
            Arrays.sort(A);
            int distinctNum = 0, lastNum = 1_000_001;
            for (int num : A) {
                if (num != lastNum) {
                    distinctNum++;
                    lastNum = num;
                }
            }

            return distinctNum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2, 1, 1, 2, 3, 1}));
    }
}
