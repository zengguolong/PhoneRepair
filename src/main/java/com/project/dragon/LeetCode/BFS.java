package com.project.dragon.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {

    }
    
    public List<Integer> rightSideView1(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                if (i == size - 1)
                    res.add(node.val);
            }
        }
        return res;
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth == result.size())
            result.add(root.val);
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }

}
