/**
 * 216，【Medium】，【Array】【Backtracking】
 * LeetCode 216. Combination Sum III
 * Related Topics: Array, Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, res, 1, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(int k, int n, List<List<Integer>> res, int pos, int sum, List<Integer> list){
        if(sum == n && list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = pos; i < 10; i++){
            list.add(i);
            helper(k, n, res, i+1, sum+i, list);
            list.remove(list.size() - 1);
        }
    }
}
