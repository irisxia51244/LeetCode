/**
 * 538，【Easy】，【Tree】
 * LeetCode 538. Convert BST to Greater Tree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
 class Solution {
    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }
    
    private int helper(TreeNode node, int sum){
        if(node == null) return sum;
        int right = helper(node.right, sum);
        node.val =  node.val + right;
        int left = helper(node.left, node.val);
        return left;
    }
}
