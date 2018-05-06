import java.util.*;
/**
 * 789，【Medium】，【Math】
 * LeetCode 789. Escape The Ghosts
 * Related Topics: Math
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1);
 */
 
 class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = Math.abs(target[0]) + Math.abs(target[1]);
        for(int[] g: ghosts){
            if(dist >= Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1])){
                return false;
            }
        }
        return true;
    }
}
