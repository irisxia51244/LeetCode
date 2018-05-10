/**
 * 495，【Medium】，【Array】
 * LeetCode 495. Teemo Attacking
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0){
            return 0;
        }
        int res = duration;
        for(int i = 1; i < timeSeries.length; i++){
            res += timeSeries[i-1]+duration-1<timeSeries[i]?duration:timeSeries[i]-timeSeries[i-1];
        }
        return res;
    }
}
