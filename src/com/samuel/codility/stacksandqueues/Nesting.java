package com.samuel.codility.stacksandqueues;

import java.util.Stack;

/**
 * A string S consisting of N characters is called properly nested if:
 *
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 *
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 */
public class Nesting {
    static class Solution {
        public int solution(String S) {
            if (S.isEmpty()) return 1;

            int opened = 0;
            for (int i = 0; i < S.length(); i++) {
                char ch = S.charAt(i);
                if (ch == '(') {
                    opened++;
                } else if (ch == ')') {
                    if (opened == 0) return 0;

                    opened--;
                }
            }

            return opened == 0 ? 1 : 0;
        }

        public int solution2(String S) {
            if (S.isEmpty()) return 1;

            Stack<Character> openChars = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                char ch = S.charAt(i);
                if (ch == '(') openChars.push(ch);
                if (ch == ')') {
                    if (openChars.isEmpty()) return 0;
                    openChars.pop();
                }
            }

            return openChars.isEmpty() ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("(()(())())"));
        System.out.println(new Solution().solution("())"));
        System.out.println(new Solution().solution("())("));
    }
}
