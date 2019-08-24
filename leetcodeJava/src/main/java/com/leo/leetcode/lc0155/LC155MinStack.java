/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * Example:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * <p>
 * stack: | 1, 2, 3,  <-
 * minStack: | 1  <-
 */
package com.leo.leetcode.lc0155;

import java.util.Stack;

class MinStack {
    Stack<Integer> s;
    Stack<Integer> minS;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        minS = new Stack<>();
    }

    public void push(int x) {
        if (s.isEmpty()) {
            minS.push(x);
        } else {
            if (x <= minS.peek()) {
                minS.push(x);
            }
        }
        s.push(x);

    }

    public void pop() {
        int temp = s.pop();
        if (temp == minS.peek()) {
            minS.pop();
        }
    }

    public int top() {
        return s.isEmpty() ? -1 : s.peek();
    }

    public int getMin() {
        return minS.isEmpty() ? -1 : minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class LC155MinStack {
    public static void main(String[] args) {

    }
}
