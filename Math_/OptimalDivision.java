import java.util.*;
/**
 * 553，【Medium】，【Math】【String】
 * LeetCode 553. Optimal Division
 * Related Topics: Math, String
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public String optimalDivision(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        sb.append(nums[0]);
        for(int i = 1; i < n; i++){
            sb.append("/");
            if(i == 1 && n > 2){
                sb.append("(");
            }
            sb.append(nums[i]);
        }
        if(n > 2){
            sb.append(")");
        }
        return sb.toString();
    }
}
