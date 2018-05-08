/**
 * 257，【Easy】，【Tree】【DFS】
 * LeetCode 257. Binary Tree Paths
 * Related Topics: Tree, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        StringBuilder sb = new StringBuilder();
        helper(root, res, sb);
        return res;
    }
    
    private void helper(TreeNode root, List<String> res, StringBuilder sb){
        if(root == null) return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            res.add(sb.toString());
        }else{
            sb.append("->");
            helper(root.left, res, sb);
            helper(root.right, res, sb);
        }
        sb.setLength(len);
    }
}
