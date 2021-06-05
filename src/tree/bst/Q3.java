package tree.bst;
/*
 * delete node
 */
public class Q3 {

	//recursive
	public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root != null){
            
            if(key<root.data)
                root.left = deleteNode(root.left, key);
            else if(key>root.data)
                root.right = deleteNode(root.right, key);
            else{
                if(root.left == null && root.right == null)
                    return null;
                else if(root.left == null)
                    return root.right;
                else if(root.right == null)
                    return root.left;
                else{
                    root.data = findMax(root.left);
                    root.left = deleteNode(root.left, root.data);
                    return root;
                }
            }
                
        }
        
        return root;
    }
    
    int findMax(TreeNode root){
        
        if(root!=null){
            while(root.right!=null)
                root = root.right;
            
            return root.data;
        }
        
        return -1;
        
    }
    
    //iterative
    public TreeNode deleteNode1(TreeNode root, int key) {
        
        TreeNode ptr=root, par=null;
        
        while(ptr!=null && ptr.data!=key){
            par = ptr;
            if(key<ptr.data)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }
        
        if(ptr == null)
            return root;
        
        //key is root
        if(par == null){
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                root.data = findAndDeleteMax(root.left, root);
                return root;
            }
        }
        else{
            if(ptr.left == null && ptr.right == null){
               if(ptr == par.left)
                   par.left = null;
                else
                    par.right = null;
            }
            else if(ptr.left == null){
                if(ptr == par.left)
                   par.left = ptr.right;
                else
                    par.right = ptr.right;
            }
            else if(ptr.right == null){
                if(ptr == par.left)
                   par.left = ptr.left;
                else
                    par.right = ptr.left;
            }
            else{
                ptr.data = findAndDeleteMax(ptr.left, ptr);
            }
            
            return root;
        }
    }
    
    int findAndDeleteMax(TreeNode node, TreeNode par){
        TreeNode ptr = node, cpar = null;
        int max = 0;
        
        while(ptr.right!=null){
            cpar = ptr;
            ptr = ptr.right;
        }
        
        if(cpar == null){
            max = node.data;
            par.left = node.left;
        }
        else{
            max = ptr.data;
            cpar.right = ptr.left;
        }
        
        return max;
    }
}
