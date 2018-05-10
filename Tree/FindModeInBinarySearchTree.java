/**
 * 501，【Easy】，【Tree】
 * LeetCode 501. Find Mode in Binary Search Tree
 * Related Topics: Tree
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    private Integer pre = null;
    private int count = 1, max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        int[] ret = new int[res.size()];
        for(int i = 0; i < ret.length; i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
    
    private void traverse(TreeNode root, List<Integer> res){
        if(root == null) return;
        traverse(root.left, res);
        
        if(pre != null){
            if(root.val == pre){
                count++;
            }else{
                count = 1;
            }
        }
        if(count > max){
            max = count;
            res.clear();
            res.add(root.val);
        }else if(count == max){
            res.add(root.val);
        }
        
        pre = root.val;
        traverse(root.right, res);
    }
}
