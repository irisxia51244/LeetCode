/**
 * 133，【Medium】，【BFS】【DFS】【Graph】
 * LeetCode 133. Clone Graph
 * Related Topics: BFS, DFS, Graph
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(copy.label, copy);
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            UndirectedGraphNode cur = q.poll();
            for(UndirectedGraphNode neighbor: cur.neighbors){
                if(!map.containsKey(neighbor.label)){
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    q.offer(neighbor);
                }
                map.get(cur.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return copy;
    }
}
