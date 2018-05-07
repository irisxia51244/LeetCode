/**
 * 114，【Medium】，【Tree】【DFS】
 * LeetCode 114. Flatten Binary Tree to Linked List
 * Related Topics: Tree，DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = new TreeNode(0);
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            node.right = cur;
            node.left = null;
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
            node = cur;
        }
        
    }
}
