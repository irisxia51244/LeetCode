/**
 * 102，【Medium】，【Tree】【BFS】
 * LeetCode 102. Binary Tree Level Order Traversal
 * Related Topics: Tree, BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res; 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < level; i++){
                TreeNode node = q.poll();
                cur.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            res.add(cur);
        }
        return res;
    }
}
