/**
 * 274，【Medium】，【HashTable】【Sort】
 * LeetCode 274. H-Index
 * Related Topics: HashTable, Sort
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int[] counts = new int[citations.length+1];
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= citations.length) counts[citations.length]++;
            else counts[citations[i]]++;
        }
        int sum = 0;
        for(int i = citations.length; i > 0; i--){
            sum += counts[i];
            if(sum >= i) return i;
        }
        return 0;
    }
}
