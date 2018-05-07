/**
 * 94，【Medium】，【HashTable】【Stack】【Tree】
 * LeetCode 94. Binary Tree Inorder Traversal
 * Related Topics: HashTable, Stack, Tree
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2:
 */


class Solution {
    //Method1: Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    //Method2: Recursive
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
    }
}
