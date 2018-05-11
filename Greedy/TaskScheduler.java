/**
 * 621，【Medium】，【Array】【Greedy】【Queue】
 * LeetCode 621. Task Scheduler
 * Related Topics: Array, Greedy, Queue
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2: 
 */

class Solution {
    //Method1
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        if(n == 0) return tasks.length;
        int[] count = new int[26];
        int max = 0, count_max = 0;
        for(char c: tasks){
            count[c - 'A']++;
            if(count[c-'A'] > max){
                max = count[c - 'A'];
                count_max = 1;
            } else if(count[c-'A'] == max){
                count_max++;
            }
        }
        return Math.max(tasks.length, (max-1)*(n+1) + count_max);
    }
    
    //Method2
    public int leastInterval(char[] tasks, int n) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(
            (a,b) -> a.getValue() == b.getValue()?a.getKey() - b.getKey():b.getValue() - a.getValue());
        q.addAll(map.entrySet());
        
        while(!q.isEmpty()){
            int count = n + 1;
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            while(!q.isEmpty() && count > 0){
                Map.Entry<Character, Integer> top = q.poll();
                top.setValue(top.getValue() - 1);
                waitList.add(top);
                count--;
                res++;
            }
            for(Map.Entry<Character, Integer> e: waitList){
                if(e.getValue() > 0) q.add(e);
            }
            if(!q.isEmpty())res += count;
        }
        return res;  
    }
}
