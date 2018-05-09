/**
 * 275，【Medium】，【Binary Search】
 * LeetCode 275. H-Index II
 * Related Topics: Binary Search
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int l = 0, r = citations.length-1;
        while(l <= r){
            int mid = (r-l)/2 + l;
            if(citations[mid] == n - mid) return citations[mid];
            else if(citations[mid] < n - mid) l = mid+1;
            else r = mid-1;
        }
        return n - l;
    }
}
