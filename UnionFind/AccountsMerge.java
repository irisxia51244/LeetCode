/**
 * 721，【Medium】，【DFS】【Union Find】
 * LeetCode 721. Accounts Merge
 * Related Topics: DFS, Union Find
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if(accounts == null || accounts.size() == 0) return res;
            
        HashMap<String, String> father = new HashMap<>();
        HashMap<String, String> name = new HashMap<>();
        HashMap<String, TreeSet<String>> union = new HashMap<>();
      
        for(List<String> a : accounts){
            for(int i = 1; i < a.size(); i++){
                father.put(a.get(i), a.get(i));
                name.put(a.get(i), a.get(0));
            }
        }
        
        for(List<String> a : accounts){
            String s = find(a.get(1), father);
            for(int i = 2; i < a.size(); i++){
                father.put(find(a.get(i), father), s);
            }
        }

        for(List<String> a : accounts){
            String s = find(a.get(1), father);
            if(!union.containsKey(s)){
                union.put(s, new TreeSet<>());
            }
            for(int i = 1; i < a.size(); i++){
                union.get(s).add(a.get(i));
            }
        }

        for(String s: union.keySet()){
            List<String> emails = new ArrayList(union.get(s));
            emails.add(0, name.get(s));
            res.add(emails);
        }
        return res;
        
        
    }
    
    private String find(String s, HashMap<String, String> father){
        while(s != father.get(s)){
            father.put(s, father.get(father.get(s)));
            s = father.get(s);
        }
        return s;
    }
}
