/**
 * 332，【Medium】，【DFS】【Graph】
 * LeetCode 332. Reconstruct Itinerary
 * Related Topics: DFS, Graph
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private HashMap<String, PriorityQueue<String>> map;
    private List<String> res;
    public List<String> findItinerary(String[][] tickets) {
        res = new LinkedList<>();
        map = new HashMap<>();
        
        for(String[] ticket: tickets){
            if(!map.containsKey(ticket[0])){
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        helper("JFK");
        return res;
    }
    
    private void helper(String airport){
        while(map.containsKey(airport) && !map.get(airport).isEmpty()){
            helper(map.get(airport).poll());
        }
        res.add(0, airport);
    }
}
