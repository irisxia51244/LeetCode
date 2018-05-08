/**
 * 217，【Easy】，【Array】【HashTable】
 * LeetCode 217. Contains Duplicate
 * Related Topics: Array, HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        HashSet<Integer> num = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(num.contains(nums[i])){
                return true;
            }
            else{
                num.add(nums[i]);
            }
        }
        return false;
    }
}
