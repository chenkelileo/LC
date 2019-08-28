/**
 * Example 1:
 * <p>
 * Input: "()"
 * ()
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
package com.leo.leetcode.lc0020;

import java.util.HashMap;
import java.util.Stack;

public class LC20ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') //need to be close together for the same type of parentheses, ([)] is false; null.peek() will  have error
                stack.pop();
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[')
                stack.pop();
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{')
                stack.pop();
            else
                return false;

        }
        return stack.isEmpty();
    }

    // much easier
    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (!stack.isEmpty() && stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


    public boolean isValid3_exercice(String s) {
        //corner
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        //initialize
        Stack<Character> stack = new Stack<>();

        //iteration
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.pop() != '(') {
                return false;
            } else if (c == ']' && !stack.isEmpty() && stack.pop() != '[') {
                return false;
            } else if (c == '}' && !stack.isEmpty() && stack.pop() != '{') {
                return false;
            }
        }

        //return
        return stack.isEmpty();
    }


    //two reference pointers
    /*
     | { [ ] ( } )  <-
       i
     j

     */
    public static boolean isValid4(String s) {
        // corner
        if (s == null || s.length() == 0) return true;
        // initialize
        char[] array = s.toCharArray();
        int i = 0;
        int j = -1;

// iteration
        while (i < s.length()) {
            if (array[i] == '(' || array[i] == '[' || array[i] == '{') {
                array[++j] = array[i++];
            } else {
                if (j == -1 || !match(array, j, i)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
            }
// return
            return j == -1;
        }

        private static boolean match(char[] array, int i, int j) {
            if (array[i] == '(' && array[j] == ')'
                    || array[i] == '[' && array[j] == ']'
                    || array[i] == '{' && array[j] == '}') {
                return true;
            }
            return false;
        }



    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        // stack.push('e')
        //System.out.print(stack.);
        isValid4("()");

    }
}
