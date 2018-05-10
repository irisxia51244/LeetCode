/**
 * 508，【Medium】，【HashTable】【Tree】
 * LeetCode 508. Most Frequent Subtree Sum
 * Related Topics: HashTable, Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    int max = Integer.MIN_VALUE;
    HashMap<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root);
        
        for(Integer sum: map.keySet()){
            if(map.get(sum) == max){
                res.add(sum);
            }
        }
        
        return res.stream().mapToInt(i->i).toArray();
    }
    
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = 0, right = 0;
        if(root.left != null){
            left = helper(root.left);
        }
        if(root.right != null){
            right = helper(root.right);
        } 
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
