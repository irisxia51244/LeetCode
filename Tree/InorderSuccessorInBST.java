/**
 * 285，【Medium】，【Tree】
 * LeetCode 285. Inorder Successor in BST
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(root.val <= p.val) return inorderSuccessor(root.right, p);
        else{
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null? root:left;
        }
    }
    
}
