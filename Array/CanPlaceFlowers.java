/**
 * 605，【Easy】，【Array】
 * LeetCode 605. Can Place Flowers
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0) return false;
        if(n == 0) return true;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) 
               && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
                flowerbed[i] = 1;
                n--;
                if(n == 0) return true;
            }
        }
        return false;
    }
}
