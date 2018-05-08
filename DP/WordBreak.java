/**
 * 139，【Medium】，【Dynamic Programming】
 * LeetCode 139. Word Break
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isWord = new boolean[s.length()+1];
        isWord[0] = true;
        
        for(int i = 1; i < isWord.length; i++){
            for(String word: wordDict){
                int len = word.length();
                if(len <= i && isWord[i - len] && s.substring(i-len, i).equals(word)){
                    isWord[i] = true;
                    break;
                }
            }
        }
        return isWord[s.length()];
    }
}
