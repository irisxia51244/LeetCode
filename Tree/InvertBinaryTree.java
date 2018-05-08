/**
 * 226，【Easy】，【tree】
 * LeetCode 226. Invert Binary Tree
 * Related Topics: tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        
        return root;
    }

}
