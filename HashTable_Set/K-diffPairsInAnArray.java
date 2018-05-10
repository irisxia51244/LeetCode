/**
 * 532，【Easy】，【Array】【Two Pointers】
 * LeetCode 532. K-diff Pairs in an Array
 * Related Topics: Array, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(k == 0){
                if(e.getValue() > 1) res++;
                
            }
            else{
                if(map.containsKey(e.getKey() + k)) res++;
            }
        }
        return res;
    }
}
