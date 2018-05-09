/**
 * 398，【Medium】，【Reservoir Sampling】
 * LeetCode 398. Random Pick Index
 * Related Topics: Reservoir Sampling
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int res = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                res = rand.nextInt(++count)==0? i:res;
            }
            
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
