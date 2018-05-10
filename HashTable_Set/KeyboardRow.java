/**
 * 500，【Easy】，【HashTable】
 * LeetCode 500. Keyboard Row
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public String[] findWords(String[] words) {
        if(words == null || words.length == 0) return new String[0];
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        ArrayList<String> oneRowWord = new ArrayList<String>();
        for(int i = 0; i < words.length; i++){
            int a = 0;
            int b = 0;
            int c = 0;
            for (int j = 0; j < words[i].length(); j++){
                if(row1.indexOf(words[i].charAt(j)) >= 0){
                    a = 1;
                }
                else if(row2.indexOf(words[i].charAt(j)) >= 0){
                    b = 1;
                }
                else if(row3.indexOf(words[i].charAt(j)) >= 0){
                    c = 1;
                }
            }
            if(a+b+c == 1){
                oneRowWord.add(words[i]);
            }
        }
        return oneRowWord.toArray(new String[oneRowWord.size()]);
    }
}
