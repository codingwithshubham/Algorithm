public class Main
{
	public static void main(String[] args) {
	    MyMap<Integer, String> map = new MyMap(17);
	    int value = map.hashtable.length;
	   // map.put(1, "hi");
    //     map.put(2, "my");
    //     map.put(3, "name");
    //     map.put(4, "is");
    //     map.put(5, "Shrayansh");
    //     map.put(6, "how");
    //     map.put(7, "are");
        map.put(8, "you");
        // map.put(9, "friends");
        map.put(8, "qwqw");
        // map.put(10, "?");

       // String value = map.get(8);
        System.out.println(value);

	   // map.put(10, 11);
	   // map.put(11, 12);
	   // map.put(12, 13);
	   // map.put(13, 14);
	    
	   // System.out.println(map.get(13));
	   // System.out.println(map.get(12));
	   // System.out.println(map.get(11));
	   // System.out.println(map.get(10));
	   // System.out.println(map.get(2));
	}
}

class MyMap<K, V>{
    final int DEFAULT_SIZE = 1<<4;
    final int MAX_SIZE = 1<<30;
    Node<K,V>[] hashtable;
    
    
    public MyMap() {
        hashtable = new Node[DEFAULT_SIZE];
    }
    
    public MyMap(int size){
        int num = 1;
        
        while(num < size){
            num = num<<1;
        }
        
        if(num > MAX_SIZE){
            System.out.println("SIZE NOT SUPPORTED");
        } else {
            hashtable = new Node[num];
        }
    }
    
    public void put(K key, V val){
        int hash = (key.hashCode() & hashtable.length-1);
        
        Node start = new Node(-1, -1);
        start.next = hashtable[hash];
        
        Node node = start;
        
        while(node.next != null){
            if(node.next.key.equals(key)){
                node.next.val = val;
                return;
            }
            
            node = node.next;
        }
        
        node.next = new Node(key, val);
        hashtable[hash] = start.next;
    }
    
    public V get(K key) {
        int hash = (key.hashCode() & hashtable.length-1);
        
        Node<K,V> node = hashtable[hash];
        while(node != null){
            if(node.key.equals(key)){
                return node.val;
            }
            
            node = node.next;
        }
        
        return null;
    }
    
}

class Node<K, V>{
    K key;
    V val;
    Node next;
    
    Node(K k, V v){
        key = k;
        val = v;
    }
}
