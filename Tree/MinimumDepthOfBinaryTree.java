/**
 * 111，【Easy】，【Tree】【DFS】【BFS】
 * LeetCode 111. Minimum Depth of Binary Tree
 * Related Topics: Tree, DFS, BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root, 1);
        return min;
    }
    
    private void helper(TreeNode node, int depth){
        if(node.left == null && node.right == null){
            min = Math.min(min, depth);
            return;
        }
        if(node.left != null) helper(node.left, depth+1);
        if(node.right != null) helper(node.right, depth+1);
    }
}
