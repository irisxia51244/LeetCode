/**
 * 505，【Medium】，【DFS】【BFS】
 * LeetCode 505. The Maze II
 * Related Topics: DFS,BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    private class Point{
        int x;
        int y;
        int dist;
        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) return -1;
        int m = maze.length, n = maze[0].length;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.offer(new Point(start[0], start[1], 0));
        
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(dist[p.x][p.y] <= p.dist) continue;
            if(p.x == destination[0] && p.y == destination[1]) return p.dist;
            dist[p.x][p.y] = p.dist;
            
            for(int i = 0; i < 4; i++){
                int newX = p.x;
                int newY = p.y;
                int newDist = p.dist;
                while(newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0){
                    newX += dir[i][0];
                    newY += dir[i][1];
                    newDist++;
                }
                newX -= dir[i][0];
                newY -= dir[i][1];
                newDist--;
                pq.offer(new Point(newX, newY, newDist));
            }
        }
        return -1;  
    }
}
