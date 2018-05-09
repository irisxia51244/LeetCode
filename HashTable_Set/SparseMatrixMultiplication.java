/**
 * 311，【Medium】，【HashTable】
 * LeetCode 311. Sparse Matrix Multiplication
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
        int [][] ans = new int[A.length][B[0].length];
        if(A == null || B == null || A.length == 0 || B.length == 0 
           || A[0].length != B.length) return ans;
        Map<Integer, HashMap<Integer, Integer>> table = new HashMap<>();
        
        for(int i = 0; i < B.length; i++){
            table.put(i, new HashMap<Integer, Integer>());
            for(int j = 0; j < B[0].length; j++){
                if(B[i][j] != 0) table.get(i).put(j, B[i][j]);
            }
        }
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] != 0){
                    for(Integer k: table.get(j).keySet()){
                        ans[i][k] += A[i][j] * table.get(j).get(k);
                    }
                }
            }
        }
        return ans;
    }
}
