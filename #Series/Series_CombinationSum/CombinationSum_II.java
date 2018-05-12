/**
 * 40，【Medium】，【Array】【Backtracking】
 * LeetCode 40. Combination Sum II
 * 有重复项，不可重复使用。has duplicate elements, use only once
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(n!), Space Complexity: O(n);
 */


class Solution {
    /*
        Backtracking，因为不可重复使用同一element，但有重复项，
                      需要sort，在每个pos时，相等的element只处理第一个，跳过后面。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i > start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            helper(candidates, target, res, i+1, sum+candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}
