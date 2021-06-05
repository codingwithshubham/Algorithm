package tree.bst;
/*
 * insert in bst
 */
public class Q2 {

	//recursive
	public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root!=null){
            
            if(val<root.data)
                root.left = insertIntoBST(root.left, val);
            else
                root.right = insertIntoBST(root.right, val);
            
            return root;
        }
        
        TreeNode node = new TreeNode(val);
        
        return node;
    }
	
	//iterative
	public TreeNode insertIntoBST1(TreeNode root, int val) {
        
        TreeNode ptr = root, par = null;
        
        TreeNode node = new TreeNode(val);
        
        while(ptr!=null){
            par = ptr;
            
            if(val<ptr.data)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }
        
        if(par == null)
            root = node;
        else{
            if(val<par.data)
                par.left = node;
            else
                par.right = node;
        }
        
        return root;
    }
}
