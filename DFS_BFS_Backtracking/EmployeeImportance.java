/**
 * 690，【Easy】，【HashTable】【DFS】【BFS】
 * LeetCode 690. Employee Importance
 * Related Topics: HashTable, DFS, BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        int res = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while(!queue.isEmpty()){
            Employee cur = queue.poll();
            res += cur.importance;
            for(Integer i: cur.subordinates){
                queue.offer(map.get(i));
            }
        }
        return res;
    }
}
