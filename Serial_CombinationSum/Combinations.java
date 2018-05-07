/**
 * 77，【Medium】，【Backtracking】
 * LeetCode 77. Combinations
 * Related Topics: Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, res, 1, new ArrayList<>());
        return res;
    }
    
    private void helper(int n, int k, List<List<Integer>> res, int pos, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
        }
        for(int i = pos; i <= n; i++){
            list.add(i);
            helper(n, k, res, i+1, list);
            list.remove(list.size() - 1);
        }
    }
}
