/**
 * 383，【Easy】，【String】
 * LeetCode 383. Ransom Note
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arrayA = new int[26];
        for(int i  = 0; i < magazine.length(); i++){
            arrayA[magazine.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < ransomNote.length();i++){
            if(--arrayA[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
