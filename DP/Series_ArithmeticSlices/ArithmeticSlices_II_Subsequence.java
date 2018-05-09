/**
 * 446，【Hard】，【Dynamic Programming】
 * LeetCode 446. Arithmetic Slices II - Subsequence
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        
        for(int i = 0; i < A.length; i++){
            maps[i] = new HashMap<Integer, Integer>();
            for(int j = 0; j < i; j++){
                long diff = (long)A[j] - A[i];
                if(diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
                
                int d = (int)diff;
                int countRight = maps[i].getOrDefault(d, 0);
                int countLeft = maps[j].getOrDefault(d, 0);
                res += countLeft;
                maps[i].put(d, countRight + countLeft + 1);
            }
        }
        return res;
    }
}
