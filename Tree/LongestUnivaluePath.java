/**
 * 687，【Easy】，【Tree】【Recursion】
 * LeetCode 687. Longest Univalue Path
 * Related Topics: Tree, Recursion
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    int max;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        max = 0;
        helper(root, root.val);
        return max;
    }
    
    private int helper(TreeNode node, int pre){
        if(node == null) return 0;
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        max = Math.max(max, left+right);
        if(pre == node.val) return Math.max(left, right) + 1;
        return 0;
    }
}
