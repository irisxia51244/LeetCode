/**
 * 594，【Easy】，【HashTable】
 * LeetCode 594. Longest Harmonious Subsequence
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findLHS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(Integer k: map.keySet()){
            if(map.containsKey(k + 1)){
                res = Math.max(res, map.get(k) + map.get(k+1));
            }
        }
        return res;
    }
}
