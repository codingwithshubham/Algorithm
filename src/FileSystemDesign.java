import java.util.*;

public class Main
{
	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		System.out.println(fs.ls("/"));
		
		fs.mkdir("/a/b/c");
		
		fs.addContentToFile("/a/b/c/d", "hello");
		
		System.out.println(fs.ls("/a"));
		
		System.out.println(fs.readContentFromFile("/a/b/c/d"));
	}
}

class FileSystem {
    Direct root;
    
    FileSystem() {
        root = new Direct();
    }
    
    List<String> ls(String path) {
        String[] folder = path.split("/");
        //System.out.println(Arrays.toString(folder));
        List<String> list = new ArrayList<>();
        
        int idx=1;
        Direct ptr = root;
        
        while(idx < folder.length){
            ptr = ptr.childDirect.get(folder[idx]);
            idx++;
        }
        
        if(ptr.isFile){
            return Collections.singletonList(ptr.name);
        }
        
        for(String name: ptr.childDirect.keySet()){
            list.add(name);
        }
        
        Collections.sort(list);
        
        return list;
    }
    
    void mkdir(String path){
        String[] folder = path.split("/");
        Direct ptr = root;
        
        for(int idx=1; idx<folder.length; idx++){
            if(!ptr.childDirect.containsKey(folder[idx])){
                Direct child = new Direct();
                child.name = folder[idx];
                
                ptr.childDirect.put(folder[idx], child);
            }
            
            ptr = ptr.childDirect.get(folder[idx]);
        }
    }
    
    void addContentToFile(String path, String content){
        String[] folder = path.split("/");
        Direct ptr = root;
        
        for(int idx=1; idx<folder.length; idx++){
            if(!ptr.childDirect.containsKey(folder[idx])){
                Direct child = new Direct();
                child.name = folder[idx];
                
                ptr.childDirect.put(folder[idx], child);
            }
            
            ptr = ptr.childDirect.get(folder[idx]);
        }
        
        ptr.isFile = true;
        ptr.text = content;
    }
    
    String readContentFromFile(String path){
        String[] folder = path.split("/");
        Direct ptr = root;
        
        for(int idx=1; idx<folder.length; idx++){
            if(!ptr.childDirect.containsKey(folder[idx])){
                Direct child = new Direct();
                child.name = folder[idx];
                
                ptr.childDirect.put(folder[idx], child);
            }
            
            ptr = ptr.childDirect.get(folder[idx]);
        }
        
        if(ptr.isFile){
            return ptr.text;
        }
        
        return null;
    }
}

class Direct {
    HashMap<String, Direct> childDirect;
    String name;
    boolean isFile;
    String text;
    
    Direct(){
        childDirect = new HashMap<>();
    }
}
