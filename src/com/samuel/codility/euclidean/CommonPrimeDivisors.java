package com.samuel.codility.euclidean;

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <p>
 * A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.
 * <p>
 * You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.
 * <p>
 * For example, given:
 * <p>
 * N = 15 and M = 75, the prime divisors are the same: {3, 5};
 * N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
 * N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A, int[] B); }
 * <p>
 * that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 15   B[0] = 75
 * A[1] = 10   B[1] = 30
 * A[2] = 3    B[2] = 5
 * the function should return 1, because only one pair (15, 75) has the same set of prime divisors.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * Z is an integer within the range [1..6,000];
 * each element of arrays A and B is an integer within the range [1..2,147,483,647].
 */
public class CommonPrimeDivisors {
    static class Solution {
        public int solution(int[] A, int[] B) {
            int samePrimeDivisorCount = 0;
            for (int i = 0; i < A.length; i++) {
                int num1 = A[i], num2 = B[i];
                int gcd = gcd(num1, num2);

                while (num1 != 1) {
                    int K = gcd(num1, gcd);
                    if (K == 1) break;

                    num1 /= K;
                }

                while (num2 != 1) {
                    int K = gcd(num2, gcd);
                    if (K == 1) break;

                    num2 /= K;
                }

                if (num1 == 1 && num2 == 1) samePrimeDivisorCount++;
            }

            return samePrimeDivisorCount;
        }

        private int gcd(int a, int b) {
            if (a % b == 0) return b;
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{15, 10, 3}, new int[]{75, 30, 5}));
    }
}
