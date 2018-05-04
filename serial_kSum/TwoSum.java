import java.util.*;
/**
 * 1，【Array】【Binary Search】,【EASY】
 * LeetCode 1. Two Sum
 * Related Topics: Array, HashTable
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(n);
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
