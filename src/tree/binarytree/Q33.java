package tree.binarytree;
/*
 * tree is isomorphic
 */
public class Q33 {
	
	static boolean isIsomorphic(TreeNode root1, TreeNode root2)  
    { 
         // code here.
         if(root1 == null && root2 == null)
            return true;
            
        if(root1==null || root2==null)
            return false;
            
        return root1.data == root2.data && (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right) || 
               isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
    }

}
