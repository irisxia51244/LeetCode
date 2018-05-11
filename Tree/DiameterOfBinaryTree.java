/**
 * 543，【Easy】，【Tree】
 * LeetCode 543. Diameter of Binary Tree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left+right);
        return Math.max(left, right) + 1;
        
    }
}
