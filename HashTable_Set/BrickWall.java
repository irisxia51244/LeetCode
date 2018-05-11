/**
 * 554，【Medium】，【HashTable】
 * LeetCode 554. Brick Wall
 * Related Topics:  HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(List<Integer> bricks: wall){
            int pos = 0;
            for(int i = 0; i < bricks.size() - 1; i++){
                pos += bricks.get(i);
                map.put(pos, map.getOrDefault(pos, 0) + 1);
                count = Math.max(count, map.get(pos));
            }
        }
        return wall.size() - count;
    }
}
