/**
 * 374，【Easy】，【Binary Search】
 * LeetCode 374. Guess Number Higher or Lower
 * Related Topics: Binary Search
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low < high){
            int mid = low + (high - low)/2;
            int cur = guess(mid);
            if(cur == 0) return mid;
            else if(cur == 1) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}
