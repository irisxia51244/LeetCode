/**
 * 210，【Medium】，【DFS】【BFS】【Graph】【Topological Sort】
 * LeetCode 210. Course Schedule II
 * Related Topics: DFS, BFS, Graph, Topological Sort
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int count = 0;
        int[] indegree = new int[numCourses];
        for(int[] pair: prerequisites){
            indegree[pair[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
                res[count++] = i;
            }
        }
        while(!q.isEmpty()){
            int course = q.poll();
            for(int[] pair: prerequisites){
                if(pair[1] == course){
                    indegree[pair[0]]--;
                    if(indegree[pair[0]] == 0){
                        q.offer(pair[0]);
                        res[count++] = pair[0];
                    }
                }
            }
        }
        return count == numCourses? res:new int[0];
    }
}
