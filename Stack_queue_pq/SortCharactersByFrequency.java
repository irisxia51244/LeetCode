/**
 * 451，【Medium】,【HashTable】【Heap】
 * LeetCode 451. Sort Characters By Frequency
 * Related Topics: HashTable, Heap
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2: 
 */

class Solution {
    //Method1: Bucket Sort
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        List<Character>[] bucket = new List[s.length()+1];
        for(char c: map.keySet()){
            int freq = map.get(c);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(c);
        }
        
        for(int i = s.length(); i > 0; i--){
            if(bucket[i] != null){
                for(char c: bucket[i]){
                    for(int j = 0; j < i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
    
    //Method2: PQ 
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(Character c: map.keySet()){
            pq.offer(c);
        }
        while(!pq.isEmpty()){
            Character cur = pq.poll();
            int cnt = map.get(cur);
            for(int i = 0; i < cnt; i++){
                sb.append(cur);
            }
        }
        return sb.toString();
        
    }
}
