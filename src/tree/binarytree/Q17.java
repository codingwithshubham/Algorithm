package tree.binarytree;
import java.util.HashMap;
/*
 *  binary tree from levelorder and inorder
 */
public class Q17 {

	static TreeNode buildTree(int inord[], int level[]){
        //your code here
        return builtTree1(inord, 0, inord.length-1, level);
    }
    
	// O(N3)
	static TreeNode builtTree(int[] inorder, int inS, int inE, int[] levelorder){
        
        if(inS>inE)
            return null;
            
        TreeNode root = new TreeNode(levelorder[0]);
        int idx = -1;
        
        for(int i=inS; i<=inE; i++){
            if(inorder[i] == levelorder[0]){
                idx = i;
                break;
            }
        }
        
        int[] lvlleft = new int[idx-1-inS+1];
        int idx1=0;
        
        for(int i=0; i<=levelorder.length-1; i++){
            int data = levelorder[i];
            
            for(int j=inS; j<=idx-1; j++){
                if(inorder[j] == data){
                   lvlleft[idx1] = data;
                   idx1++;
                   break;
                }
            }
        }
        
        int[] lvlright = new int[inE - idx];
        int idx2=0;
        
        for(int i=0; i<=levelorder.length-1; i++){
            int data = levelorder[i];
            
            for(int j=idx+1; j<=inE; j++){
                if(inorder[j] == data){
                   lvlright[idx2] = data;
                   idx2++;
                   break;
                }
            }
        }
        
        root.left = builtTree(inorder, inS, idx-1, lvlleft);
        root.right = builtTree(inorder, idx+1, inE, lvlright);
        
        return root;
    }
    
    //using hashmap O(N2)
	static TreeNode builtTree1(int[] inorder, int inS, int inE, int[] levelorder){
        
        if(inS>inE)
            return null;
            
        TreeNode root = new TreeNode(levelorder[0]);
        int idx = -1;
        
        for(int i=inS; i<=inE; i++){
            if(inorder[i] == levelorder[0]){
                idx = i;
                break;
            }
        }
        
        HashMap<Integer, Integer> inmap = new HashMap<>();
        
        for(int i=inS; i<=inE; i++){
            inmap.put(inorder[i], i);
        }
        
        int[] lvlleft = new int[idx-1-inS+1];
        int idx1=0;
        
        for(int i=0; i<=levelorder.length-1; i++){
            int data = levelorder[i];
            
            if(inmap.get(data)<idx){
                   lvlleft[idx1] = data;
                   idx1++;
            }
        }
        
        int[] lvlright = new int[inE - idx];
        int idx2=0;
        
        for(int i=0; i<=levelorder.length-1; i++){
            int data = levelorder[i];
            
            if(inmap.get(data)>idx){
               lvlright[idx2] = data;
               idx2++;
            }
        }
        
        root.left = builtTree(inorder, inS, idx-1, lvlleft);
        root.right = builtTree(inorder, idx+1, inE, lvlright);
        
        return root;
    }
}
