/**
 * 475，【Easy】，【Binary Search】
 * LeetCode 475. Heaters
 * Related Topics: Binary Search
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        Arrays.sort(heaters);
        for(int house: houses){
            int index = Arrays.binarySearch(heaters, house);
            int dist1 = Integer.MAX_VALUE;
            int dist2 = Integer.MAX_VALUE;
            if(index < 0){
                index = -(index + 1);
            }
            if(index > 0){
                dist1 = Math.abs(house - heaters[index - 1]);
            }
            if(index < heaters.length){
                dist2 = Math.abs(house - heaters[index]);
            }
            radius = Math.max(radius, Math.min(dist1, dist2));
        }
        return radius;
    }
}
