import java.util.*;
/**
 * 454，【Medium】，【HashTable】【Binary Search】
 * LeetCode 454. 4Sum II
 * Related Topics: HashTable, Binary Search
 * @author Iris Xia
 * Time Complexity: O(n^2), Space Complexity: O(n);
 */

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || B == null || C == null || D == null || A.length == 0
          || B.length == 0 || C.length == 0 || D.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int sum = A[i]+B[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                if(map.containsKey(-sum)){
                    res += map.get(-sum);
                }
            }
        }
        return res;
    }
}
