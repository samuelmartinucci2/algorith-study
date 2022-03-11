package com.samuel.codility.iterations;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 *
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
 *
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 *
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..2,147,483,647].
 */
public class BinaryGap {
    private static class Solution {
        public int solution(int N) {
            if (N < 4) return 0;

            int maxGap = 0, currentGap = -1;
            int totalBits = (int)(Math.log(N) / Math.log(2) + 1);
            for (int bitPos = 0; bitPos < totalBits; bitPos++) {
                int bitVal = (int) Math.pow(2, bitPos);
                if ((N & bitVal) == bitVal) {
                    maxGap = Math.max(maxGap, currentGap);
                    currentGap = 0;
                    continue;
                }
                if (currentGap >= 0) currentGap++;
            }
            return maxGap;
        }

        public int solution2(int N) {
            if (N < 4) return 0;

            int bitPos = 0, maxGap = 0, zeroBits = -1;
            while (true) {
                double bitValue = Math.pow(2, bitPos++);
                if (bitValue > N) return maxGap;

                if ((N & (int)bitValue) == bitValue) {
                    maxGap = Math.max(maxGap, zeroBits);
                    zeroBits = 0;
                } else {
                    if (zeroBits >= 0) zeroBits++;
                }
            }
        }

        public int solution3(int N) {
            if (N < 4) return 0;

            int maxGap = 0, zeroCount = -1;
            String s = Integer.toBinaryString(N);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    maxGap = Math.max(maxGap, zeroCount);
                    zeroCount = 0;
                } else if (zeroCount >= 0) zeroCount++;
            }
            return maxGap;
        }
    }

    public static void main(String[] args) {
        assert(new Solution().solution(1041) == 5);
    }
}
