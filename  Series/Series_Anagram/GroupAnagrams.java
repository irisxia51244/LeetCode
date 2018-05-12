/**
 * 40，【Medium】，【HashTable】【String】
 * LeetCode 49. Group Anagrams
 * Related Topics: HashTable, Stirng
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(n);
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars); 
            if(!map.containsKey(temp)) map.put(temp, new ArrayList<String>());
            map.get(temp).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
