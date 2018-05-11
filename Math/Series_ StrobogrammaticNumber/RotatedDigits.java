/**
 * 788，【Easy】，【String】
 * LeetCode 788. Rotated Digits
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(isValid(i)) count++;
        }
        return count;
    }
    
    private boolean isValid(int N){
        boolean valid = false;
        while(N > 0){
            int temp = N % 10;
            if(temp == 2 || temp == 5 || temp == 6 || temp == 9) valid = true;
            if(temp == 3 || temp == 4 || temp == 7) return false;
            N/= 10;
        }
        return valid;
    }
}
