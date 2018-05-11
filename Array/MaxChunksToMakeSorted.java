/**
 * 769，【Medium】，【Array】
 * LeetCode 769. Max Chunks To Make Sorted
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = -1;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if(max == i){
                res++;
            }
        }
        return res;
    }
}
