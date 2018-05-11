/**
 * 307，【Medium】，【BIT】【Segment Tree】
 * LeetCode 307. Range Sum Query - Mutable
 * Related Topics: Binary Index Tree, Segment Tree
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2:
 */

class NumArray {
    //Method1: Segment Tree
    private int[] tree;
    private int[] nums;
    private int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n*2];
        for(int i = n, j = 0; j < n; i++, j++){
            tree[i] = nums[j];
        }
        for(int i = n-1; i > 0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }
    
    public void update(int i, int val) {
        i += n;
        tree[i] = val;
        while(i > 0){
            int left = (i%2 == 0)?i:i-1;
            int right = (i%2 == 0)?i+1:i;
            tree[i/2] = tree[left] + tree[right];
            i/=2;
        }
    }
    
    public int sumRange(int i, int j) {
        i += n;
        j += n;
        int sum = 0;
        while(i <= j){
            if(i%2 != 0){
                sum += tree[i];
                i++;
            }
            if(j%2 != 1){
                sum += tree[j];
                j--;
            }
            i/=2;
            j/=2;
        }
        return sum;
    }
    
    //Method2: BIT
    class NumArray {
    private int[] tree;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int sum;
        int lowbit;
        tree = new int[nums.length + 1];
        for(int i = 1; i < tree.length; i++){
            sum = 0;
            lowbit = i & (-i);
            for(int j = i; j > i - lowbit; j--){
                sum+=nums[j-1];
            }
            tree[i] = sum;
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for(int j = i+1; j < tree.length; j+=j & (-j)){
            tree[j] += diff;
        }
    }
    
    public int sumRange(int i, int j) {
        return sum(j+1) - sum(i);
    }
    
    public int sum(int k){
        int sum = 0;
        for(int i = k; i > 0; i-= i&(-i)){
            sum += tree[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
