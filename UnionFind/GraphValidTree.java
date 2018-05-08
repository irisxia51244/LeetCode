/**
 * 261，【Medium】，【DFS】【BFS】【UnionFind】【Graph】
 * LeetCode 261. Graph Valid Tree
 * Related Topics: DFS, BFS, Union Find, Graph
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1 && edges.length == 0) return true;
        if(n < 1 || edges == null || edges.length != n -1) return false;
        
        int[] parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = -1;
        }
        
        for(int[] edge: edges){
            int vertex1 = find(parents, edge[0]);
            int vertex2 = find(parents, edge[1]);
            if(vertex1 == vertex2) return false;
            parents[vertex1] = vertex2;
        }
        return edges.length == n-1;
    }
    
    private int find(int[] parents, int vertex){
        while(parents[vertex] != -1){
            vertex =  parents[vertex];
        }
        return vertex;
    }
}
