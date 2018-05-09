/**
 * 370，【Medium】，【Array】
 * LeetCode 370. Range Addition
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] indexes : updates){
            res[indexes[0]] += indexes[2];
            if(indexes[1] < length-1){
                res[indexes[1]+1] -= indexes[2];
            }
        }
        
        for(int i = 1; i < length; i++){
            res[i] += res[i-1];
        }
        return res;
    }
}
