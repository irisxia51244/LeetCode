/**
 * 783，【Easy】，【BST】
 * LeetCode 783. Minimum Distance Between BST Nodes
 * Related Topics: Binary Search Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private int min;
    private Integer pre;
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        min = Integer.MAX_VALUE;
        pre = null;
        helper(root);
        return min;
    }
    
    private void helper(TreeNode node){
        if(node == null) return;
        helper(node.left);
        if(pre != null){
            min = Math.min(min, node.val - pre);
        }
        pre = node.val;
        helper(node.right);
    }
}
