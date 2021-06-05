package tree.bst;
/*
 * search in bst
 */
public class Q1 {

	//recursive
	public TreeNode searchBST(TreeNode root, int val) {
        
        if(root!=null){
            
            if(val<root.data)
                return searchBST(root.left, val);
            else if (val>root.data)
                return searchBST(root.right, val);
        }
        
        return root;
    }
	
	//iterative
	public TreeNode searchBST1(TreeNode root, int val) {
        
        while(root!=null){
            
            if(val<root.data)
                root = root.left;
            else if (val>root.data)
                root = root.right;
            else
                break;
        }
        
        return root;
    }
}
