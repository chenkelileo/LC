//Given a binary tree, return the inorder traversal of its nodes' values.
//
//        Example:
//
//        Input: [1,null,2,3]
//        1
//          \
//           2
//          /
//         3
//
//        Output: [1,3,2]
//        Follow up: Recursive solution is trivial, could you do it iteratively?
package com.leo.jakeclass;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class C6BstInorderTraversal_LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public List<Integer> inOrderTraversalIter(TreeNode root) {
        //corner case
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
