/**
 * 349，【Easy】，【HashTable】【TwoPointers】【BinarySearch】
 * LeetCode 349. Intersection of Two Arrays
 * Related Topics: HashTable, Two Pointers, Binary Search, Sort
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            nums1Set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(nums1Set.contains(nums2[i])){
                intersection.add(nums2[i]);
            }
        }
        int[] intersect = new int[intersection.size()];
        int index = 0;
        for(int num: intersection){
            intersect[index++] = num;
        }
        return  intersect;
    }
}
