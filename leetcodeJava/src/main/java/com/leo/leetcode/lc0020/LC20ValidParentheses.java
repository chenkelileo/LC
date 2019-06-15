package com.leo.leetcode.lc0020;

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
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else if(!stack.isEmpty() && stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        // stack.push('e')
        //System.out.print(stack.);
    }
}
