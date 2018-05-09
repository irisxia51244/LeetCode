/**
 * 447，【Easy】，【HashTable】 
 * LeetCode 447. Number of Boomerangs
 * Related Topics: Hash Table
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        if(points == null) return 0;
        Map<Integer, Integer> distance = new HashMap<Integer, Integer>();
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                if(i == j){
                    continue;
                }
                int d = getDistance(points[i], points[j]);
                distance.put(d, distance.getOrDefault(d, 0)+1);
            }
            for(int value: distance.values()){
                res += value*(value - 1);
            }
            distance.clear();
        }
        return res;
    }
    
    private int getDistance(int[] x1, int[] x2){
        int dx = x1[0] - x2[0];
        int dy = x1[1] - x2[1];
        return dx*dx + dy*dy;
    }
}
