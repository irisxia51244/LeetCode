/**
 * 199，【Medium】，【Tree】【DFS】【BFS】
 * LeetCode 199. Binary Tree Right Side View
 * Related Topics: Tree, DFS, BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.offer(root);
        
        while(!q.isEmpty()){
            int count = q.size();
            TreeNode cur = new TreeNode(0);
            for(int i = 0; i < count; i++){
                cur = q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(cur.val);
        }
        return res;
    }
}
