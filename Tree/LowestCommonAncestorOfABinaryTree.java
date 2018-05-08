/**
 * 236，【Medium】，【Tree】
 * LeetCode 236. Lowest Common Ancestor of a Binary Tree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        map.put(root, null);
        stack.push(root);
        
        while(!map.containsKey(p) || !map.containsKey(q)){
            TreeNode cur = stack.pop();
            if(cur.left!=null){
                map.put(cur.left, cur);
                stack.push(cur.left);
            }
            if(cur.right!=null){
                map.put(cur.right,cur);
                stack.push(cur.right);
            }
        }
        
        HashSet<TreeNode> set = new HashSet<>();
        while(p!=null){
            set.add(p);
            p = map.get(p);
        }
        while(!set.contains(q)){
            q = map.get(q);
        }
        return q;
    }
}
