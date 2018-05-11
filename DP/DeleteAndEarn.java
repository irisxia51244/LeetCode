/**
 * 740，【Medium】，【DP】
 * LeetCode 740. Delete and Earn
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) +num);
        }
        int delete = 0, keep = 0;
        for(int num: map.keySet()){
            //if num-1 exist
            if(map.containsKey(num-1)){
                int temp = Math.max(delete, keep + map.get(num));//either delete num-1 or num
                keep = Math.max(delete, keep); //if keep, num-1 either keep or delete
                delete = temp;
            }
            else{
                keep = Math.max(delete, keep);
                delete += map.get(num);
            }
        }
        return Math.max(delete, keep);
    }
}
