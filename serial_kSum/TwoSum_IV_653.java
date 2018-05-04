import java.util.*;
/**
 * 653，【EASY】，【Tree】
 * LeetCode 653. Two Sum IV - Input is a BST
 * Related Topics: Tree
 * @author Iris Xia
 * Method 1: Time Complexity: O(nlogn), Space Complexity: O(logn) best, O(n) worst;
 * Method 2: Time Complexity: O(n), Space Complexity: O(n)
 * Method 3: Time Complexity: O(n), Space Complexity: O(n)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  
    //Method 1: Binary Search
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    
    private boolean dfs(TreeNode root, TreeNode cur, int k){
        if(cur == null) return false;
        return helper(root, cur, k-cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }
    
    private boolean helper(TreeNode root, TreeNode cur, int target){
        if(root == null) return false;
        if((root.val == target) && (root != cur)) return true;
        if(root.val < target) return helper(root.right, cur, target);
        if(root.val > target) return helper(root.left, cur, target);
        return false;
    }
  
    //Method 2: HashSet, works for not BST
    public boolean findTarget2(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper2(root, k, set);
    }
    
    private boolean helper2(TreeNode node, int k, HashSet<Integer> set){
        if(node == null) return false;
        if(set.contains(k-node.val)) return true;
        set.add(node.val);
        return helper2(node.left, k, set) || helper2(node.right, k, set);
    }
    
    //Method 3: Inorder, binary search
    public boolean findTarget3(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int l = 0, r = list.size()-1;
        while(l < r){
            int sum = list.get(l) + list.get(r);
            if(sum == k) return true;
            else if(sum < k) l++;
            else r--;
        }
        return false;
    }
    
    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
