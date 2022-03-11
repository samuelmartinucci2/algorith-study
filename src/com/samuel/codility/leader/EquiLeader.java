package com.samuel.codility.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * The leader of this array is the value that occurs in more than half of the elements of A.
 *
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * we can find two equi leaders:
 *
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 *
 * For example, given:
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */
public class EquiLeader {
    static class Solution {
        public int solution(int[] A) {
            int consecutiveOccurences = 0, value = A[0];
            for (int num : A) {
                if (consecutiveOccurences == 0) {
                    consecutiveOccurences++;
                    value = num;
                } else {
                    consecutiveOccurences += value == num ? 1 : -1;
                }
            }

            int[] prefixSum = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                if (A[i] == value) prefixSum[i]++;
                if (i > 0) prefixSum[i] = prefixSum[i] + prefixSum[i - 1];
            }

            int totalLeaders = prefixSum[A.length - 1];
            if (totalLeaders <= A.length / 2) return 0;

            int equiLeaderCount = 0;
            for (int i = 1; i < A.length; i++) {
                int leadersSlice1 = prefixSum[i - 1], slice1Size = i;
                int leadersSlice2 = totalLeaders - leadersSlice1, slice2Size = A.length - i;
                if (leadersSlice1 > slice1Size / 2 && leadersSlice2 > slice2Size / 2) equiLeaderCount++;
            }

            return equiLeaderCount;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{4,3,4,4,4,2}));
    }
}
