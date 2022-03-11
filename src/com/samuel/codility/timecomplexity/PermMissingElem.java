package com.samuel.codility.timecomplexity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 */
public class PermMissingElem {
    private static class Solution {
        public int solution(int[] A) {
            if (A.length == 0) return 1;

            Arrays.sort(A);
            for (int i = 0; i < A.length; i++) {
                int expectedNumber = i + 1;
                if (A[i] != expectedNumber) return expectedNumber;
            }
            return A.length + 1;
        }

        public int solution2(int[] A) {
            if (A.length == 0) return 1;

            final Set<Integer> numbers = new HashSet<>(A.length);
            for (int num : A) numbers.add(num);
            for (int i = 1; i <= A.length; i++) {
                if (!numbers.contains(i)) return i;
            }

            return A.length + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution2(new int[] { 1,2,3,5 }));
    }
}
