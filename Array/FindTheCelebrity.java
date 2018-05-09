/**
 * 277，【Medium】，【Array】
 * LeetCode 277. Find the Celebrity
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int c = 0;
        for(int i = 0; i < n; i++){
            if(knows(c, i)) c = i;
        }
        for(int i = 0; i < c; i++){
            if(knows(c, i)) return -1;
        }
        for(int i = 0; i < n; i++){
            if(!knows(i, c)) return -1;
        }
        return c;
    }
}
