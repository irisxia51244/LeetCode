/**
 * 455，【Easy】，【Greedy】
 * LeetCode 455. Assign Cookies
 * Related Topics: Greedy
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j = 0; i < g.length && j < s.length; j++){
            if(g[i] <= s[j]){
                i++;
            }
        }
        return i;
    }
}
