package com.samuel.codility.primeandcomposite;

/**
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
 *
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int N); }
 *
 * that, given a positive integer N, returns the number of its factors.
 *
 * For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..2,147,483,647].
 */
public class CountFactors {
    static class Solution {
        public int solution(int N) {
            int factors = 0;
            for (int i = 1; i <= Math.sqrt(N); i++) {
                if (N % i != 0) continue;

                // If the product of the division is the number, it means both factors involved are the same
                // i.e.: 4 = 2 * 2. Otherwise there are two factors: i.e.: 6 = 2 * 3
                factors += N / i == i ? 1 : 2;
            }
            return factors;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinPerimeterRectangle.Solution().solution(24));
        System.out.println(new MinPerimeterRectangle.Solution().solution(16));
        System.out.println(new MinPerimeterRectangle.Solution().solution(36));
    }
}
