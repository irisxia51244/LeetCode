/**
 * 520，【Easy】，【String】
 * LeetCode 520. Detect Capital
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))){
                count ++;
            }
        }
        if(count == 0){
            return true;
        }
        if(count == 1 && Character.isUpperCase(word.charAt(0))){
           return true;
        }
        if(count == word.length()){
            return true;
        }
        return false;
        
    }
}
