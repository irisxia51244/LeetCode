import java.util.*;
/**
 * 413，【Medium】，【Math】【Dynamic Programming】
 * LeetCode 413. Arithmetic Slices
 * Related Topics: Math, Dynamic Programming
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int res = 0, cur = 1;
        for(int i = 2; i < A.length; i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                res += cur;
                cur++;
            }
            else{
                cur = 1;
            }
        }
        return res;
    }
}
