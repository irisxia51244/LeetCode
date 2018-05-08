/**
 * 128，【Hard】，【Array】【Union Find】
 * LeetCode 128. Longest Consecutive Sequence
 * Related Topics:  Array, Union Find
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int num: nums){
            set.add(num);
        }
        for(int num:nums){
            int count = 1;
            if(set.remove(num)){
                int left = num-1, right = num+1;
                while(set.remove(left)){
                    count++;
                    left--;
                }
                while(set.remove(right)){
                    count++;
                    right++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
