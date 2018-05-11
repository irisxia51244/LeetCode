/**
 * 652，【Medium】，【Tree】
 * LeetCode 652. Find Duplicate Subtrees
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        helper(root, map, res);
        return res;
    }
    
    public String helper(TreeNode cur, HashMap<String, Integer> map, List<TreeNode> res){
        if(cur == null) return "#";
        String serial = cur.val + "," + helper(cur.left, map, res) + "," + helper(cur.right, map, res);
        if(map.getOrDefault(serial, 0) == 1) res.add(cur);
        map.put(serial, map.getOrDefault(serial,0)+1);
        return serial;
    }
}
