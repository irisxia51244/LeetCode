/**
 * 526，【Medium】，【Backtracking】
 * LeetCode 526. Beautiful Arrangement
 * Related Topics: Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N+1];
        helper(N, N, visited);
        return count;
    }
    
    public void helper(int N, int index, boolean[] visited){
        if(index == 0){
            count ++;
            return;
        }
        for(int i = 1; i <= N; i++){
            if(visited[i] || (index%i != 0 && i%index != 0)){
                continue;
            }
            visited[i] = true;
            helper(N, index-1, visited);
            visited[i] = false;
        }
        
    }
}
