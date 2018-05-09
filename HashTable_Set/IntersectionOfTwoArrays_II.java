/**
 * 350，【Easy】，【HashTable】【TwoPointers】【BinarySearch】
 * LeetCode 350. Intersection of Two Arrays II
 * Related Topics: HashTable, Two Pointers, Binary Search, Sort
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0){
            int[] result = new int[0];
            return result;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            count.put(nums1[i], count.getOrDefault(nums1[i], 0)+1);
        }
        for(int i = 0; i < nums2.length; i++){
            Integer value = count.get(nums2[i]);
            if(value == null){
                continue;
            }
            else if(value > 0){
                ans.add(nums2[i]);
                count.put(nums2[i], value-1);
            }
        }
        int[] result = new int[ans.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = ans.get(i);
        }
        return result;
        
        
    }
}
