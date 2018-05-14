/**
 * 336，【Hard】，【Hashtable】【String】【Trie】
 * LeetCode 336. Palindrome Pairs
 * Related Topics: HashTable, String, Trie
 * @author Iris Xia
 * Time Complexity: O(nm^2), Space Complexity: O(n);
 */

class Solution {
    /*
     HashMap存所有string和对应index
     把所有word和其index加入hashmap中
     如果有“”，加所有palidrome(因为遍历中中，长度为0的string无法分割为两半处理，eg, 遍历中会产生[a,""]，不会产生["", a])
     遍历所有word：
        将word中的每一位设为分割点，分割成两个substring
        如果substring1是回文，找substring2的reverse，如果有，加入[2_reverse,1]
        如果substring2是回文，找substring1的reverse，如果有，加入[2,1_reverse]
        *注意找到的reverse不能是substring自己
        *注意word本身只能被处理一次，所以判断substring2时需要判断是否长度为0
     */
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
