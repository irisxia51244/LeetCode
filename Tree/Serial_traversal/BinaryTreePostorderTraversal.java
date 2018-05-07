/**
 * 145，【Hard】，【Stack】【Tree】
 * LeetCode 145. Binary Tree Postorder Traversal
 * Related Topics: Stack, Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    //Method1: Iterative
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while(true){
            if(cur != null){
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            if(stack.isEmpty()){
                return res;
            }
            cur = stack.pop();
            if(cur.right != null && !stack.isEmpty() && cur.right == stack.peek()){
                stack.pop();
                stack.push(cur);
                cur = cur.right;
            }else{
                res.add(cur.val);
                cur = null;
            }
        }
    }
    
    //Method2: Recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode node, List<Integer> res){
        if(node == null) return;
        helper(node.left, res);
        helper(node.right, res);
        res.add(node.val);
    }
}
