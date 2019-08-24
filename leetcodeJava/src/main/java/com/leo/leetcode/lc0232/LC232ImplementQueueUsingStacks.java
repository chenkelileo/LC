/**
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * <p>
 * Queue: <-  5,6,7,8,9<-
 * Stack 1:  |9<-
 * Stack 2:  |8,7,6,5 <-
 */
package com.leo.leetcode.lc0232;

import java.util.Stack;

class MyQueue {

    /**
     * Initialize your data structure here.
     */
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        shuffle();
        return s2.isEmpty() ? -1 : s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        shuffle();
        return s2.isEmpty() ? -1 : s2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void shuffle() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class LC232ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_1 = obj.peek();
        int param_2 = obj.pop();
        boolean param_3 = obj.empty();
        System.out.println(param_1 + " " + param_2 + " " + param_3);
    }
}
