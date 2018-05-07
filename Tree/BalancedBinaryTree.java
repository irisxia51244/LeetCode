/**
 * 110，【Easy】，【Tree】【DFS】
 * LeetCode 110. Balanced Binary Tree
 * Related Topics: Tree, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    
    private int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left);
        if(left != -1){
            int right = helper(node.right);
            if(right != -1){
                return Math.abs(left-right)>1? -1 : Math.max(left,right)+1;
            }
        }
        return -1;
    }
}
