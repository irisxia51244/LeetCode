/**
 * 341，【Medium】，【Stack】【Design】
 * LeetCode 341. Flatten Nested List Iterator
 * Related Topics: Stack, Design
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

public class NestedIterator implements Iterator<Integer> {
    
    public Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for(int i = nestedList.size()-1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        while(this.hasNext() && !stack.peek().isInteger()){
            NestedInteger cur = stack.pop();
            for(int i = cur.getList().size()-1; i >= 0; i--){
                stack.push(cur.getList().get(i));
            }
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            if(stack.peek().isInteger()) return true;
            NestedInteger cur = stack.pop();
            for(int i = cur.getList().size()-1; i >= 0; i--){
                stack.push(cur.getList().get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
