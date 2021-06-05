package tree.binarytree;

/*
 * binary tree from postorder and inorder
 */
public class Q16 {

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return built(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
    
	static TreeNode built(int[] postorder, int poS, int poE, int[] inorder, int inS, int inE){
        if(poS>poE)
            return null;
        
        TreeNode node = new TreeNode(postorder[poE]);
        
        int idx = inS;
        
        while(idx<=inE && inorder[idx]!=postorder[poE]){
            idx++;
        }
        
        int lpoS = poS;
        int linS = inS;
        int linE = idx-1;
        int lpoE = linE-linS+lpoS;
        
        int rpoS = lpoE+1;
        int rpoE = poE-1;
        int rinS = idx+1;
        int rinE = inE;
        
        node.left = built(postorder, lpoS, lpoE, inorder, linS, linE);
        node.right = built(postorder, rpoS, rpoE, inorder, rinS, rinE);
        
        return node;
    }
}
