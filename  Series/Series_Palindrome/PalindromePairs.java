/**
 * 336，【Hard】，【Hashtable】【String】【Trie】
 * LeetCode 336. Palindrome Pairs
 * Related Topics: HashTable, String, Trie
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length < 2) return res;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }
        
        if(map.containsKey("")){
            int emptyIndex = map.get("");
            for(int i = 0; i < words.length; i++){
                if(isPalindrome(words[i]) && i != emptyIndex){
                    res.add(Arrays.asList(emptyIndex, map.get(words[i])));
                }
            }
        }
        
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                String subStr1 = words[i].substring(0,j);
                String subStr2 = words[i].substring(j);
                if(isPalindrome(subStr1)){
                    String subStr2_r = new StringBuilder(subStr2).reverse().toString();
                    if(map.containsKey(subStr2_r) && map.get(subStr2_r) != i){
                        res.add(Arrays.asList(map.get(subStr2_r), i));
                    }
                }
                
                if(subStr2.length() != 0 && isPalindrome(subStr2)){
                    String subStr1_r = new StringBuilder(subStr1).reverse().toString();
                    if(map.containsKey(subStr1_r) && map.get(subStr1_r) != i){
                        res.add(Arrays.asList(i, map.get(subStr1_r)));
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
