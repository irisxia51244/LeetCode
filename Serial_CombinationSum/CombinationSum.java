/**
 * 39，【Medium】，【Array】【Backtracking】
 * LeetCode 39. Combination Sum
 * Related Topics: Array, Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates, target, res, 0, 0, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int[] candidates, int target, List<List<Integer>> res,
                       int start, int sum, List<Integer> list){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) return;
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            helper(candidates, target, res, i, sum+candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}
