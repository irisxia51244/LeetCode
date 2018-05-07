/**
 * 78，【Medium】，【Array】【Backtracking】【Bit】
 * LeetCode 78. Subsets
 * Related Topics: Array, Backtracking, Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(nums, res, 0, new ArrayList<>());
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, int pos, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            dfs(nums, res, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
