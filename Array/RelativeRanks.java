/**
 * 506，【Easy】
 * LeetCode 506. Relative Ranks
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        ArrayList<Integer> numsList = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
        	numsList.add(nums[i]);
        }
        String[] ans = new String[nums.length];
        Collections.sort(numsList, Collections.reverseOrder());
        
        for(int i = 0; i < nums.length; i++){
            int rank = numsList.indexOf(nums[i]);
            if(rank == 0){
                ans[i] = "Gold Medal";
            }
            else if (rank == 1){
                ans[i] = "Silver Medal";
            }
            else if (rank == 2){
                ans[i] = "Bronze Medal";
            }
            else{
                ans[i] = Integer.toString(rank+1);
            }
        }
        return ans;
    }
}
