package tree.bst;
/*
 * lca
 */
public class Q6 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return root;
        else if(p.data<root.data && q.data<root.data)
            return lowestCommonAncestor(root.left, p, q);
        else if(p.data>root.data && q.data>root.data)
            return lowestCommonAncestor(root.right, p, q);
        
        return root;
    }
}
