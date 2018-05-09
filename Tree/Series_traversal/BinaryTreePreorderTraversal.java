/**
 * 144，【Medium】，【Stack】【Tree】
 * LeetCode 144. Binary Tree Preorder Traversal
 * Related Topics: Stack, Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    //Method1: Iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return res;
    }
    
    //Method2: Recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode node, List<Integer> res){
        if(node == null) return;
        res.add(node.val);
        helper(node.left, res);
        helper(node.right, res);
    }
}
