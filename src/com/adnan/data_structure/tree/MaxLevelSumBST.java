package com.adnan.bst;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxLevelSumBST {
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

 /* Not working correctly using Queue */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int max = root.val;
        int maxLevel = 1;
        int level = 1;

        while(!queue.isEmpty()) {
            int left = 0;
            int right = 0;
            TreeNode node = queue.poll();
            level++;

            if (node.left != null) {
                left = node.left.val;
                queue.add(node.left);
            }

            if (node.right != null) {
                right = node.right.val;
                queue.add(node.right);
            }

            if (max < (left + right)) {
                max = (left + right);
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}
