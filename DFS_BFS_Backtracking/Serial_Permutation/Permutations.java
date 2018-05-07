/**
 * 46，【Medium】，【Backtracking】
 * LeetCode 46. Permutations
 * Related Topics: Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        helper(nums, res, new ArrayList<>());
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res ,List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(list.contains(nums[i])) continue;
                list.add(nums[i]);
                helper(nums, res, list);
                list.remove(list.size()-1);
            }
        }
    }
}
