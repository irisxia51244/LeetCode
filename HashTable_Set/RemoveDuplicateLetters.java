/**
 * 316，【Hard】，【Stack】【Greedy】
 * LeetCode 316. Remove Duplicate Letters
 * Related Topics: Stack, Greedy
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        
        char[] res = new char[map.size()];
        int start = 0, end = findEnd(map);
        for(int i = 0; i < res.length; i++){
            char minChar = 'z'+1;
            for(int j = start; j <= end; j++){
                if(map.containsKey(s.charAt(j)) && s.charAt(j) < minChar){
                    minChar = s.charAt(j);  
                    start = j+1;
                }
            }
            res[i] = minChar;
            map.remove(minChar);
            if(s.charAt(end) == minChar){
                end = findEnd(map);
            }
        }
        return new String(res);
    }
    
    private int findEnd(HashMap<Character, Integer> map){
        int min = Integer.MAX_VALUE;
        for(int i : map.values()){
            min = Math.min(min, i);
        }
        return min;
    }
}
