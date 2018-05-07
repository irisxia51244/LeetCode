/**
 * 112，【Easy】，【Tree】【DFS】
 * LeetCode 112. Path Sum
 * Related Topics: Tree, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root, sum, root.val);
    }
    
    private boolean helper(TreeNode node, int target, int sum){
        if(node.left == null && node.right == null){
            return sum == target;
        }
        boolean left = node.left == null?false:helper(node.left, target, sum+node.left.val);
        boolean right = node.right == null?false:helper(node.right, target, sum+node.right.val);
        return left || right;
    }
}
