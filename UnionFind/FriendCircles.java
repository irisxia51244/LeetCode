/**
 * 547，【Medium】，【DFS】【Union Find】
 * LeetCode 547. Friend Circles
 * Related Topics: DFS, Union Find
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    static int[] father;
    static int count;
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;
        
        int m = M.length;
        count = m;
        father = new int[m];
        
        for(int i = 0; i < m; i++){
            father[i] = i;
        }
        
        for(int i = 0; i < m; i++){
            for(int j = i+1; j < m; j++){
                if(M[i][j] == 1){
                    union(i,j);
                }
            }
        }
        return count;
    }
    
    private int find(int i){
        while(i != father[i]){
            father[i] = father[father[i]];
            i = father[i];
        }
        return i;
    }
    
    private void union(int i, int j){
        int father1 = find(i);
        int father2 = find(j);
        if(father1 != father2){
            father[father1] = father2;
            count--;
        }
    }
}
