/**
 * 286，【Medium】，【BFS】
 * LeetCode 286. Walls and Gates
 * Related Topics: BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private final int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    helper(rooms, i, j);
                }
            }
        }
        return;
    }
    
    private void helper(int[][] rooms, int i, int j){
        int m = rooms.length, n = rooms[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i*n+j);
        while(!q.isEmpty()){
            int cur = q.poll();
            i = cur/n;
            j = cur%n;
            for(int[] dir:dirs){
                int x= i + dir[0];
                int y= j + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] > rooms[i][j] + 1){
                    rooms[x][y] = rooms[i][j] + 1;
                    q.offer(x*n+y);
                }
            }
        }
    }
}
