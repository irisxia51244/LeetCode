/**
 * 499，【Hard】，【DFS】【BFS】
 * LeetCode 499. The Maze III
 * Related Topics: DFS, BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    private class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        String s;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = Integer.MAX_VALUE;
            this.s = "";
        }
        
        public Point(int x, int y, int dist, String s){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.s = s;
        }
        
        public int compareTo(Point p){
            return this.dist==p.dist?s.compareTo(p.s):this.dist-p.dist;
        }
    }
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) return "impossible";
        int m = maze.length, n = maze[0].length;
        Point[][] points = new Point[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                points[i][j] = new Point(i, j);
            }
        }
        
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        String[] dStr = new String[]{"r","d","l","u"};        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(ball[0], ball[1], 0, ""));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            if(points[p.x][p.y].compareTo(p) <= 0) continue;
            points[p.x][p.y] = p;
            for(int i = 0; i < 4; i++){
                int newX = p.x;
                int newY = p.y;
                int newDist = p.dist;
                while(newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0
                     && (newX != hole[0] || newY != hole[1])){
                    newX += dir[i][0];
                    newY += dir[i][1];
                    newDist++;
                }
                if(newX != hole[0] || newY != hole[1]){
                    newX -= dir[i][0];
                    newY -= dir[i][1];
                    newDist--;
                }
                q.offer(new Point(newX, newY, newDist, p.s+dStr[i]));
            }
        }
        return points[hole[0]][hole[1]].dist == Integer.MAX_VALUE?
            "impossible":points[hole[0]][hole[1]].s;
        
    }
}
