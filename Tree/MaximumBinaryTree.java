/**
 * 654，【Medium】，【Tree】
 * LeetCode 654. Maximum Binary Tree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null){
            return null;
        }
        return constructSubTree(nums, 0, nums.length -1);
    }
    
    private TreeNode constructSubTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int maxIndex = start;
        for(int i = start; i <= end; i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructSubTree(nums, start, maxIndex-1);
        root.right = constructSubTree(nums, maxIndex+1, end);
        return root;
    }
}
