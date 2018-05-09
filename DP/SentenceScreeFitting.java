/**
 * 418，【Medium】，【Dynamic Programming】
 * LeetCode 418. Sentence Screen Fitting
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if(sentence == null || sentence.length == 0) return 0;
        int n = sentence.length;
        int[] dp = new int[sentence.length];
        int prev = 0, len = 0;
        for(int i = 0; i < n; i++){
            if(i != 0 && len > 0) len -= sentence[i-1].length() + 1;
            while(len + sentence[prev%n].length() <= cols){
                len += sentence[prev++%n].length() + 1;
            }
            dp[i] = prev;
        }
        int count = 0;
        for(int i = 0, k = 0; i < rows; i++){
            count += dp[k] - k;
            k = dp[k] % n;
        }
        return count/n;
    }
}
