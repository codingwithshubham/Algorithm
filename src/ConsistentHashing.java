import java.util.*;

public class ConsistentHashing
{
    
    static String[] ringArray = new String[16];
    static TreeSet<Integer> nodeKeys = new TreeSet<>();
    
    
    static void addServer(String server){
        int hash = hash(server);
        int idx = hash%16;
        
        if(ringArray[idx] != null){
            System.out.println("server collision");
            return;
        } else {
            nodeKeys.add(idx);
            ringArray[idx] = server;
        }
    }
    
    static void removeServer(String server){
        int hash = hash(server);
        int idx = hash%16;
        
        if(ringArray[idx] == null){
            System.out.println("server not present");
            return;
        } else {
            ringArray[idx] = null;
            nodeKeys.remove(idx);
        }
    }
    
    static void getServer(String key){
        int hash = hash(key);
        int idx = hash%16;
        
        // System.out.println(key+" "+idx);
        
        String server = find(idx);
        System.out.println("key is served by server: "+server);
    }
    
    private static int hash(String key){
        
        return key.hashCode();
    }
    
    static String find(int idx) {
        
        if(ringArray[idx] != null){
            return ringArray[idx];
        }
        
        ArrayList<Integer> keys = new ArrayList<>(nodeKeys);
        Integer[] tmp = keys.toArray(new Integer[0]);
        
        if(idx >= tmp[tmp.length-1]){
            return ringArray[tmp[0]];
        }
        
        int low = 0, high = tmp.length-1;
        
        while(low < high){
            int mid = low + (high-low)/2;
            
            if(tmp[mid] <= idx){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        
        return ringArray[tmp[low]];
    }
    

	public static void main(String[] args){
		    addServer("server1");
        addServer("server2");
        addServer("server3");
        
        System.out.println(Arrays.toString(ringArray));


        getServer("key1"); 
        getServer("key67890"); 

        removeServer("server2");
        System.out.println("After removing server2");

        getServer("key1"); 
        getServer("key67890"); 
	}
	
	
}
