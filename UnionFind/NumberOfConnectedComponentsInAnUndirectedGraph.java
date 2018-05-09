/**
 * 323，【Medium】，【BFS】【DFS】【Union Find】【Graph】
 * LeetCode 323. Number of Connected Components in an Undirected Graph
 * Related Topics: DFS, BFS, Union Find, Graph
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = n;
        int[] father = new int[n];
        Arrays.fill(father, -1);
        for(int[] e: edges){
            int vertex1 = find(father, e[0]);
            int vertex2 = find(father, e[1]);
            if(vertex1 != vertex2) {
                res--;
                father[vertex1] = vertex2;
            }
        }
        return res;
    }
    
    private int find(int[] father, int vertex){
        while(father[vertex] != -1){
            vertex = father[vertex];
        }
        return vertex;
    }
}
