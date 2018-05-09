/**
 * 298，【Medium】，【Tree】
 * LeetCode 298. Binary Tree Longest Consecutive Sequence
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private int max;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        if(root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }
    
    private void helper(TreeNode node, int len, int target){
        if(node == null) return;
        if(node.val == target){
            len++;
        }else{
            len = 1;
        }
        max = Math.max(len, max);
        dfs(node.left, len, node.val+1);
        dfs(node.right, len, node.val+1);
    }
}
