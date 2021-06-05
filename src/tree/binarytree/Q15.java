package tree.binarytree;

/*
 *  binary tree from preorder and inorder
 */
public class Q15 {
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return built(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
	static TreeNode built(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE){
        if(preS>preE)
            return null;
        
        TreeNode node = new TreeNode(preorder[preS]);
        
        int idx = inS;
        
        while(idx<=inE && inorder[idx]!=preorder[preS]){
            idx++;
        }
        
        int lpreS = preS+1;
        int linS = inS;
        int linE = idx-1;
        int lpreE = linE-linS+lpreS;
        
        int rpreS = lpreE+1;
        int rpreE = preE;
        int rinS = idx+1;
        int rinE = inE;
        
        node.left = built(preorder, lpreS, lpreE, inorder, linS, linE);
        node.right = built(preorder, rpreS, rpreE, inorder, rinS, rinE);
        
        return node;
    }
}
