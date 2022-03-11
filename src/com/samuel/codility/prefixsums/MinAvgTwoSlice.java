package com.samuel.codility.prefixsums;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * contains the following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
public class MinAvgTwoSlice {
    private static class Solution {
        public int solution(int[] A) {
            int N = A.length;
            double minAvg = Double.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < N - 1; i++) {
                double avgOfTwo = (A[i] + A[i + 1]) / 2.0f;
                if (avgOfTwo < minAvg) {
                    minIdx = i;
                    minAvg = avgOfTwo;
                }

                if (i < N - 2) {
                    double avgOfThree = (A[i] + A[i + 1] + A[i + 2]) / 3.0f;
                    if (avgOfThree < minAvg) {
                        minIdx = i;
                        minAvg = avgOfThree;
                    }
                }
            }
            return minIdx;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] {4,2,2,5,1,5,8}));
    }
}
