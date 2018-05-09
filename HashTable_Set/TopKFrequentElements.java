/**
 * 347，【Medium】，【HashTable】【Heap】
 * LeetCode 347. Top K Frequent Elements
 * Related Topics: HashTable, Heap
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2: 
 */

class Solution {
    //Method1: Bucket Sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new ArrayList<>(); 
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length-1; i >= 0 && res.size() < k; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
    
    //Method2: Heap
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0 || k == 0) return res; 
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) +1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> (b.getValue() - a.getValue()));
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = pq.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
