package com.leo.jakeclass;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class C6BstPostorderTraversal_LC145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
//        if(root == null){
//            return res;
//        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.addFirst(root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return res;
    }
}
