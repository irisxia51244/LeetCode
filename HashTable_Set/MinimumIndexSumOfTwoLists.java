/**
 * 599，【Easy】，【HashTable】
 * LeetCode 599. Minimum Index Sum of Two Lists
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> place = new HashMap<String, Integer>();
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < list1.length; i++){
            place.put(list1[i], i);
        }
        for(int i = 0; i < list2.length; i++){
            Integer index = place.get(list2[i]);
            if(index != null){
                if(min == Integer.MAX_VALUE){
                    min = index+i;
                }
                if(index+i == min){
                    res.add(list2[i]);
                }
                if(index+i < min){
                    res.clear();
                    res.add(list2[i]);
                    min = index+1;
                }
            }
        }
        return res.toArray(new String[res.size()]);
        
    }
}
