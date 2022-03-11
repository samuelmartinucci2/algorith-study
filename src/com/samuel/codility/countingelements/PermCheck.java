package com.samuel.codility.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * is a permutation, but array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * the function should return 1.
 * <p>
 * Given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */
public class PermCheck {
    private static class Solution {
        public int solution(int[] A) {
            final int N = A.length;
            final Set<Integer> numbers = new HashSet<>(N);
            for (int i = 0; i < N; i++) {
                if (A[i] > N) return 0;
                numbers.add(A[i]);
            }
            return numbers.size() == N ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{4, 1, 3, 2}));
        System.out.println(new Solution().solution(new int[]{4, 1, 3}));
        System.out.println(new Solution().solution(new int[]{5, 1, 2, 3}));
    }
}
