package com.samuel.codility.prefixsums;

import java.util.Arrays;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
 * <p>
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 * <p>
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 * <p>
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * <p>
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P and Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 */
public class GenomicRangeQuery {
    private static class Solution {
        public int[] solution(String S, int[] P, int[] Q) {
            int[][] prefixSum = new int[S.length() + 1][3];
            for (int i = 1; i <= S.length(); i++) {
                int gen = S.charAt(i - 1);
                if (gen == 'A') {
                    prefixSum[i][0]++;
                } else if (gen == 'C') {
                    prefixSum[i][1]++;
                } else if (gen == 'G') {
                    prefixSum[i][2]++;
                }
            }

            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i][0] += prefixSum[i - 1][0];
                prefixSum[i][1] += prefixSum[i - 1][1];
                prefixSum[i][2] += prefixSum[i - 1][2];
            }


            int[] rtrn = new int[P.length];
            for (int i = 0; i < P.length; i++) {
                int start = P[i], end = Q[i] + 1;
                if (prefixSum[end][0] - prefixSum[start][0] > 0) {
                    rtrn[i] = 1;
                } else if (prefixSum[end][1] - prefixSum[start][1] > 0) {
                    rtrn[i] = 2;
                } else if (prefixSum[end][2] - prefixSum[start][2] > 0) {
                    rtrn[i] = 3;
                } else {
                    rtrn[i] = 4;
                }
            }
            return rtrn;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution("CAGCCTA ", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        System.out.println(Arrays.toString(new Solution().solution("CAGCCTA ", new int[]{2, 4, 0}, new int[]{4, 4, 6})));
    }
}
