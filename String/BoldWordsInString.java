/**
 * 758，【Easy】，【String】
 * LeetCode 758. Bold Words in String
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String boldWords(String[] words, String S) {
        if(words == null || words.length == 0 || S == null || S.length() == 0) return S;
        StringBuilder sb = new StringBuilder();
        boolean[] isBold = new boolean[S.length()];
        for(String word : words){
            helper(S, word, isBold);
        }
        for(int i = 0; i < S.length(); i++){
            if(isBold[i] && (i == 0 || !isBold[i-1])){
                sb.append("<b>");
            }
            sb.append(S.charAt(i));
            if(isBold[i] && (i == S.length() - 1 || !isBold[i+1])){
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
    
    private void helper(String S, String word, boolean[] isBold){
        for(int i = 0; i <= S.length() - word.length(); i++){
            String str = S.substring(i, i + word.length());
            if(str.equals(word)){
                for(int j = i; j < i + word.length(); j++){
                    isBold[j] = true;
                }
            }
        }
    }
}
