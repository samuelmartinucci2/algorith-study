package com.samuel.codility.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 *
 * For example, consider array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 *
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 *
 * For example, given array A such that
 *
 *  A[0] = 3    A[1] = 4    A[2] =  3
 *  A[3] = 2    A[4] = 3    A[5] = -1
 *  A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
public class Dominator {
    static class Solution {
        public int solution(int[] A) {
            if (A.length == 0) return -1;

            int value = A[0];
            int occurrences = 1;
            for (int i = 1; i < A.length; i++) {
                int num = A[i];
                if (occurrences == 0) {
                    value = num;
                    occurrences++;
                } else {
                    occurrences += value == num ? 1 : -1;
                }
            }

            int count = 0, idx = -1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == value) {
                    count++;
                    idx = i;
                }
            }

            if (count > A.length / 2) return idx;
            else return -1;
        }

        public int solution2(int[] A) {
            if (A.length == 0) return -1;

            int value = A[0];
            int occurrences = 0;
            Map<Integer, IndexedValue> counters = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                int num = A[i];
                IndexedValue counter = counters.getOrDefault(num, new IndexedValue(i, 0));
                counter.count++;
                counters.put(num, counter);

                if (occurrences == 0) {
                    value = num;
                    occurrences++;
                } else {
                    occurrences += value == num ? 1 : -1;
                }
            }

            IndexedValue count = counters.get(value);

            if (count.count > A.length / 2) return count.idx;
            else return -1;
        }

        static class IndexedValue {
            public int idx;
            public int count;

            public IndexedValue(int idx, int count) {
                this.idx = idx;
                this.count = count;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution2(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
        System.out.println(new Solution().solution2(new int[]{0,0,1,1,1}));
    }
}
