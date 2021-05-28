package tree;
import java.util.*;
/*
 *  lca of bt
 */
public class Q24 {
	
	// requires an list addition to recursion stack
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> l1 = new ArrayList();
        ArrayList<TreeNode> l2 = new ArrayList();
        
        path(root, l1, p);
        path(root, l2, q);
        
        TreeNode anc = null;
        //System.out.println(l1);
        
        for(int i=l1.size()-1, j=l2.size()-1; i>=0&&j>=0; i--,j--){
            //System.out.println(l1.get(i).val+" "+l2.get(j).val);
            if(l1.get(i).data == l2.get(j).data)
                anc = l1.get(i);
            else
                break;
        }
        
        return anc;
    }
    
	//Efficient no list required
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root!=null){
            
             
            if(root==p || root==q)
                return root;
            
            TreeNode leftlca = lowestCommonAncestor1(root.left, p, q);
            TreeNode rightlca = lowestCommonAncestor1(root.right, p, q);
            
            if(leftlca!=null && rightlca!=null)
                return root;
            
            if(leftlca!=null)
                return leftlca;
            else
                return rightlca;
                
        }
        return null;
    }

    boolean path(TreeNode root, ArrayList<TreeNode> path, TreeNode tar){
        
        if(root!=null){
            if(root.data == tar.data){
                path.add(tar);
                return true;
            }
            
            if(path(root.left, path, tar)||path(root.right, path, tar)){
                path.add(root);
                return true;
            } 
        }
        return false;
    }
}
