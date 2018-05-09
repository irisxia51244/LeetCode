/**
 * 90，【Medium】，【Array】【Backtracking】
 * LeetCode 90. Subsets II
 * Related Topics: Array, Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    
    private void dfs(int[] nums, int pos, List<Integer> list){
        ans.add(new ArrayList<>(list));
        for(int i = pos; i < nums.length; i++){
            if(i>pos && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            dfs(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
