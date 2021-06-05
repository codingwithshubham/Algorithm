package tree.bst;
/*
 *  bt is bst or not
 */
public class Q7 {

	public boolean isValidBST(TreeNode root) {
        return isBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }
    
    boolean isBST(int min, int max, TreeNode node){
        if(node == null)
            return true;
        
        return node.data>min && node.data<max && isBST(min, node.data, node.left) && isBST(node.data, max, node.right);
    }
}
