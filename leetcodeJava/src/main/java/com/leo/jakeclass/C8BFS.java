package com.leo.jakeclass;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C8BFS {
    public static void printBFSTraversal(TreeNode root) {
        //corner
        if(root == null) {
            return;
        }
        //init
        Queue<TreeNode> queue = new LinkedList<>();
        //Deque<TreeNode> dq = new LinkedList<>();//test
        queue.offer(root);
        //iter
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val);
            if(temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
            }
        }
        //return
    }

    public static void bfs(TreeNode root) {
        String s;
        int a;
        //corner case
        //init
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        //queue.offerLast(root);
        // queue always empty
        //iteration
        while(!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.offerLast(cur.left);
            }
            if(cur.right != null) {
                queue.offerLast(cur.right);
            }
        }
        //return
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printBFSTraversal(root);
        bfs(root);
    }

}
