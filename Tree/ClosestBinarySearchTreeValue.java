/**
 * 270，【Easy】，【Binary Search】【Tree】
 * LeetCode 270. Closest Binary Search Tree Value
 * Related Topics: Binary Search, Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int closestValue(TreeNode root, double target) {
        int pre = root.val;
        TreeNode child = target < pre? root.left:root.right;
        if(child == null) return pre;
        int cur = closestValue(child, target);
        return Math.abs(pre - target) < Math.abs(cur - target)? pre:cur;
    }
}
