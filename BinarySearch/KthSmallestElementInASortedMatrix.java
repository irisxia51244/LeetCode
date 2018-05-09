/**
 * 378，【Medium】，【Binary Search】【Heap】
 * LeetCode 378. Kth Smallest Element in a Sorted Matrix
 * Related Topics: Binary Search, Heap
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2:
 */

class Solution {
    //Method1: Binary Search
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        
        while(left+1 < right){
            int mid = (right -left)/2 + left;
            int num = helper(matrix, mid);
            if(num >= k) right = mid;
            else left = mid;
        }
        if(helper(matrix, right) <= k-1) return right;
        return left;
    }
    
    private int helper(int[][] matrix, int target){
        int n = matrix.length;
        int res = 0;
        int i = n-1; int j = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] < target){
                res += i+1;
                j++;
            }else{
                i--;
            }
        }
        return res;
    }
    
    //Method2: PQ
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for(int i = 0; i < matrix[0].length;i++){
            int[] index = new int[2];
            index[1] = i;
            pq.offer(index);
        }
        
        for(int i = 0; i < k-1; i++){
            int[] index = pq.poll();
            if(index[0] == matrix.length-1) continue;
            index[0]++;
            pq.offer(index);
        }
        int[] res = pq.poll();
        return matrix[res[0]][res[1]];
    }
}
