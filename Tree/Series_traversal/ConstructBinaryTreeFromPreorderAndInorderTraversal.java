/**
 * 105，【Medium】，【Array】【Tree】【DFS】
 * LeetCode 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Related Topics: Array, Tree, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 ||inorder.length == 0
          || preorder.length != inorder.length) return null;
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if(preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = 0;
        for(int i = 0; i <= inEnd; i++){
            if(inorder[i] == root.val){
                idx = i;
                break;
            }
        }
        root.left = helper(preorder, inorder, preStart+1, inStart, idx-1);
        root.right = helper(preorder, inorder, preStart+idx-inStart+1, idx+1, inEnd);
        return root;
    }
}
