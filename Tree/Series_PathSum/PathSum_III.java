/**
 * 437，【Easy】，【Tree】
 * LeetCode 437. Path Sum III
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, sum, 0, map);
    }
    
    public int helper(TreeNode node, int target, int sum, HashMap<Integer, Integer> map){
        if(node == null) return 0;
        sum += node.val;
        int count = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        count += helper(node.left, target, sum, map);
        count += helper(node.right, target, sum, map);
        
        map.put(sum, map.get(sum) - 1);
        return count;
    }
}
