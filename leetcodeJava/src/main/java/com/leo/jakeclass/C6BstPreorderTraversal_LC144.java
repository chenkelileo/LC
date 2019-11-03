package com.leo.jakeclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class C6BstPreorderTraversal_LC144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        //corner case
        // if(root == null) {
        //     return new ArrayList<>();
        // }
        //init
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //iter
        while (root != null || !stack.isEmpty()) {
            while (root != null) {

                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}
