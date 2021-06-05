package tree.binarytree;
/*
 *  Full binary tree with preorder and postorder
 */

public class Q18 {
	
	 public static TreeNode constructFromPrePost(int[] pre, int[] post) {
	        return builtTree(pre, 0, pre.length-1, post, 0, post.length-1);
	    }
	    
	 static TreeNode builtTree(int[] pre, int preS, int preE, int[] post, int poS, int poE){
        if(preS>preE)
            return null;
        
        TreeNode root = new TreeNode(pre[preS]);
        
        if(preS == preE)
            return root;
            
        int idx = 0;
        for( ; idx<=poE; idx++){
            if(post[idx] == pre[preS+1])
                break;
        }
        
        int lpoS = poS;
        int lpoE = idx;
        int lpreS = preS+1;
        int lpreE = lpoE-lpoS+lpreS;
        int rpreS = lpreE+1;
        int rpreE = preE;
        int rpoS = lpoE+1;
        int rpoE = poE-1;
        
        root.left = builtTree(pre, lpreS, lpreE, post, lpoS, lpoE);
        root.right = builtTree(pre, rpreS, rpreE, post, rpoS, rpoE);
        
        return root;
        
    }
}
