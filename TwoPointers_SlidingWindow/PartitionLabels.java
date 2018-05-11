/**
 * 763，【Medium】，【Two Pointers】【Greedy】
 * LeetCode 763. Partition Labels
 * Related Topics: Two Pointers, Greedy
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        HashMap <Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            map.put(S.charAt(i), i);
        }
        int end = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end, map.get(S.charAt(i)));
            if(end == i){
            	int len = end -start;
            	if(ans.size() == 0){
            		len ++;
            	}
            	ans.add(len);
            	start = i;
            }
        }
        return ans;
    }
}
