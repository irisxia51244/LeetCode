/**
 * 697，【Easy】，【Array】
 * LeetCode 697. Degree of an Array
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 1;
        int res = Integer.MAX_VALUE;
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1,i,i});
            }
            else{
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
                max = Math.max(max, temp[0]);
            }
        }
        for(int[] val:map.values()){
            if(val[0] == max){
                res = Math.min(res, val[2] - val[1] + 1);
            }
        }
        return res;
    }
}
