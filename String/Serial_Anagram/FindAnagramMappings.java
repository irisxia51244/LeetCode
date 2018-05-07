/**
 * 760，【Easy】，【HashTable】
 * LeetCode 760. Find Anagram Mappings
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */


class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0) return new int[0];
        int[] res = new int[A.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < B.length; i++){
            if(!map.containsKey(B[i])){
                map.put(B[i], new ArrayList<Integer>());
            }
            map.get(B[i]).add(i);
        }
        
        for(int i = 0; i < A.length; i++){
            res[i] = map.get(A[i]).remove(map.get(A[i]).size()-1);
        }
        
        return res;
    }
}
