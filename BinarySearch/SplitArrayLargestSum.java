/**
 * 410，【Hard】，【Binary Search】【Dynamic Programming】
 * LeetCode 410. Split Array Largest Sum
 * Related Topics: Binary Search, Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0) return 0;
        int max = -1; long sum = 0;
        for(int num:nums){
            max = Math.max(num, max);
            sum += num;
        }
        if(m == 1) return (int)sum;
        
        long l = max, r = sum;
        while(l<=r){
            long mid = (l+r)/2;
            if(helper(mid, nums, m)){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return (int)l;
    }
    
    public boolean helper(long mid, int[] nums, int m){
        int count = 1;
        long sum = 0;
        for(int num:nums){
            sum+=num;
            if(sum > mid){
                sum = num;
                count++;
                if(count>m) return false;
            }
        }
        return true;
    }
}
