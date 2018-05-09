/**
 * 314，【Medium】，【HashTable】
 * LeetCode 314. Binary Tree Vertical Order Traversal
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    /* BFS, 用两个queue，一个存node，一个存col的处理顺序，TreeMap<col, 这行所有的node>
     * 1、当存node的queue不为空时，取出当前node，取出当前列数
     * 2、如果map中还没有这一列，加入这一列
     * 3、将当前node加入map
     * 4、顺序处理child：
     *      如果有left child，将left child放入存node的queue中，将col-1放入存col的queue中
     *      如果有right child，将right child放入存node的queue中，将col+1放入存col的queue中
     * 5、将TreeMap中entry加入res
     * follow up: track min, max, 在每层left/right loop下加Math.min/max
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(); //store node val at each col
        if(root == null) return ans;
        
        Queue<TreeNode> nodes = new LinkedList<>();//for each node, add to the node queue
        Queue<Integer> cols = new LinkedList<>();//for each node, add to col
        nodes.offer(root);
        cols.offer(0);
        
        while(!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            int col = cols.poll();
            if(!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
            map.get(col).add(node.val);
            
            if(node.left != null){
                nodes.offer(node.left);
                cols.offer(col-1);
            }
            if(node.right != null){
                nodes.offer(node.right);
                cols.offer(col+1);
            }
        }
        
        for(int col: map.keySet()) ans.add(map.get(col));
        return ans;
    }
}
