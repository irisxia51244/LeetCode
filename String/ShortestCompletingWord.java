/**
 * 748，【Medium】，【HashTable】
 * LeetCode 748. Shortest Completing Word
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        if(licensePlate == null || licensePlate.length() == 0
          ||words == null || words.length == 0) return ""; 
        String res = "";
        int[] chars = new int[26];
        for(char c: licensePlate.toLowerCase().toCharArray()){
            if(Character.isLetter(c)){
                chars[c-'a']++;
            }
        }        
        
        for(String w: words){
            if((res.length() == 0 || w.length() < res.length()) && isComplete(chars, w)){
                res = w;
            }
        }
        return res;
    }
    
    public boolean isComplete(int[] chars, String word){
        int[] cur = new int[26];
        for(char c: word.toLowerCase().toCharArray()){
            cur[c-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(chars[i] > cur[i]) return false;
        }
        return true;
    }
}
