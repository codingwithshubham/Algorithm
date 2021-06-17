package tree.binarytree;
import java.util.*;
/*
 *  binary tree from parent array
 */
public class Q31 {
	
	static TreeNode root = null;

	// O(n2)
	public static TreeNode createTree(int parent[], int N)
    {
        //Your code here
        
        int rootIndex = -1;
        
        for(int i=0; i<parent.length; i++){
            if(parent[i] == -1){
                rootIndex = i;
                break;
            }
        }
        
        return create(rootIndex, parent);
        
    }
    
    static TreeNode create(int val, int[] par){
        
    	TreeNode node = new TreeNode(val);
        
        int leftIndex=-1, rightIndex = -1;
        
        for(int i=0; i<par.length; i++){
            if(par[i] == val){
                leftIndex = i;
                break;
            }
        }
        
        if(leftIndex!=-1){
           for(int i=leftIndex+1; i<par.length; i++){
                if(par[i] == val){
                    rightIndex = i;
                    break;
                }
            } 
        }
        
        if(leftIndex!=-1){
            node.left = create(leftIndex, par);
        }
        
        if(rightIndex!=-1){
            node.right = create(rightIndex, par);
        }
        
        //System.out.println(val+" "+node.data+" "+leftIndex+" "+rightIndex);
        return node;
    }

//==========================================================================

    //O(N) time O(N) Space
    public static TreeNode createTree1(int parent[], int N)
    {
        //Your code here
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<parent.length; i++){
            map.putIfAbsent(parent[i], new ArrayList<>());
            map.get(parent[i]).add(i);
        }
        
        
        return construct(map.get(-1).get(0), map);
    }
    
    static TreeNode construct(int key, HashMap<Integer, ArrayList<Integer>> map){
        
        TreeNode node = new TreeNode(key);
        ArrayList<Integer> list = map.get(key);
        
        if(list!=null && list.size()!=0){
            int leftKey = list.get(0);
            
            node.left = construct(leftKey, map);
            
            if(list.size()==2){
                int rightKey = list.get(1);
                node.right = construct(rightKey, map);
            }
        }
        
        return node;
        
    }

//==========================================================================

    // gfg O(N) time O(N) Space
    public static TreeNode createTree2(int parent[], int N)
    {
        //Your code here
    	TreeNode[] nodes = new TreeNode[parent.length];
        
        for(int i=0; i<parent.length; i++){
            create(parent, nodes, i);
        }
        
        return root; // global var
    }
    
    static void create(int[] parent, TreeNode[] nodes, int idx){
        
        if(nodes[idx] == null){
            
            if(parent[idx] == -1){
                root = new TreeNode(idx);
                nodes[idx] = root;
                return;
            }
                
            TreeNode node = new TreeNode(idx);
            
            nodes[idx] = node;
            
            if(nodes[parent[idx]] == null)
                create(parent, nodes, parent[idx]);
                
            TreeNode par = nodes[parent[idx]];

        if(par.left==null)
                par.left = node;
            else
                par.right = node;
        }
        
    }
}
