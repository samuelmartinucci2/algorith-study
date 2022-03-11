package com.samuel.codility.maximumslice;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 *
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 *
 * For example, array A such that:
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * contains the following example double slices:
 *
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 *
 * For example, given:
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
public class MaxDoubleSlice {

    static class Solution {
        public int solution(int[] A) {
            // Even though positions 0 and A.length are not valid ones, let's create a bigger array to make
            // it easier to prevent ArrayIndexOutOfBounds.
            int[] maxEndingHere = new int[A.length];

            // X will always be + 1 and Z will always be -1, so first and last elements are unreachable.
            for (int i = A.length - 2; i > 0; i--) {
                // 0 case in case we find a negative, we can set a range with 0 elements.
                maxEndingHere[i] = Math.max(maxEndingHere[i + 1] + A[i], 0);
            }

            int[] maxStartingHere = new int[A.length];
            for (int i = 1; i < A.length - 1; i++) {
                // 0 case in case we find a negative, we can set a range with 0 elements.
                maxStartingHere[i] = Math.max(maxStartingHere[i - 1] + A[i], 0);
            }

            int maxSum = 0;
            for (int i = 1; i < A.length - 1; i++) {
                maxSum = Math.max(maxSum, maxStartingHere[i - 1] + maxEndingHere[i + 1]);
            }

            return maxSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] { 3, 2, 6, -1, 4, 5, -1, 2 }));
        System.out.println(new Solution().solution(new int[] { 0, 10, -5, -2, 0 }));
        System.out.println(new Solution().solution(new int[] { 5, 17, 0, 3 }));
    }
}
