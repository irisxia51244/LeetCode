/**
 * 299，【Medium】，【HashTable】
 * LeetCode 299. Bulls and Cows
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String getHint(String secret, String guess) {
        if(secret == null || guess == null || 
           secret.length() != guess.length() || secret.length() == 0) return "0A0B";
        
        int[] bucket = new int[10];
        int bull = 0, cow = 0;
        for(int i = 0; i < secret.length(); i++){
            int a = secret.charAt(i) - '0';
            int b = guess.charAt(i) - '0';
            if(a == b) bull++;
            else{
                if(bucket[a] < 0) cow++;
                if(bucket[b] > 0) cow++;
                bucket[a]++;
                bucket[b]--;
            }
        }
        return bull+"A"+cow+"B";
    }
}
