/**
 * 567，【Medium】，【Two Pointers】
 * LeetCode 567. Permutation in String
 * Related Topics: Two Pointers
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() == 0 
           || s2.length() == 0 ||s1.length() > s2.length()){
            return false;
        }
        int[] count = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        if(match(count)) return true;
        
        for(int i = s1.length(); i < s2.length(); i++){
            count[s2.charAt(i)-'a']--;
            count[s2.charAt(i-s1.length())-'a']++;
            if(match(count)) return true;
        }
        return false;
    }
    
    private boolean match(int[] count){
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
