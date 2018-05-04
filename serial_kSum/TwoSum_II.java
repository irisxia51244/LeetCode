/* 
 * LeetCode 167. Two Sum II - Input array is sorted
 * Related Topic: Array, Binary Search
 * @author Iris Xia
 * Time Complexity: O(logn), Space Complexity: O(1);
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length == 0) return res;
        int l = 0, r = numbers.length-1;
        while(l < r){
            int curSum = numbers[l] + numbers[r];
            if(curSum == target){
                res[0] = l+1;
                res[1] = r+1;
                break;
            }
            else if(curSum < target){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}
