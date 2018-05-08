/**
 * 146，【Medium】，【Design】
 * LeetCode 146. LRU Cache
 * Related Topics: Design
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class LRUCache{
	private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
	private DLinkedNode head = new DLinkedNode();
    private DLinkedNode tail = new DLinkedNode();
	private int capacity;
	public LRUCache(int capacity){
		cache = new HashMap<Integer, DLinkedNode>();
		this.capacity = capacity;
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
	}
	
	public int get(int key){
		if(cache.containsKey(key)){
			DLinkedNode node = cache.get(key);
			node.update();
			return node.val;
		}else return -1;
	}
	
	public void put(int key, int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
           	if(capacity == 0) return;
		    if(cache.size() == capacity){
			    cache.remove(tail.removeFromTail().key);
		    }
		    node = new DLinkedNode();
            node.key = key;
            node.val = value;
		    node.add();
		    cache.put(key, node); 
        }
        else{
            node.val = value;
            node.update();
        }

	}
	
	class DLinkedNode{
		int key;
		int val;
		DLinkedNode pre;
		DLinkedNode next;
        
		/*
		 * always add after head
		 */
		private void add(){
			this.pre = head;
			this.next = head.next;
			head.next.pre = this;
			head.next = this;
		}
		
		/*
		 * remove itself from the linked list
		 */
		private void remove(){
			this.pre.next = this.next;
			this.next.pre = this.pre;
		}
		
		/**
		 * move current node to head
		 */
		private void update(){
			this.remove();
			this.add();
		}
		
		/**
		 * pop tail
		 */
		private DLinkedNode removeFromTail(){
			DLinkedNode temp= tail.pre;
			temp.remove();
			return temp;
		}
	}
}
