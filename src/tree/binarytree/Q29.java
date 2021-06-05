package tree.binarytree;

/*
 *  binary tree isBalanced
 */
public class Q29 {

	//recursive O(n2)
	public static boolean isBalanced(TreeNode root) {
        if(root!=null)
            return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(height(root.left)-height(root.right))<=1;
            

        return true;
    }
    
    public static int height(TreeNode node){
        if(node != null)
            return Math.max(height(node.left), height(node.right))+1;
        else
            return 0;

    }

    // recursive (n)
	public static boolean isBalancedOpt1(TreeNode root) {
	        
	        return isB1(root).b;
	    }
	    
	static Pair5 isB1(TreeNode root){
        if(root!=null){
        	Pair5 left = isB1(root.left);
        	Pair5 right = isB1(root.right);
            
            return new Pair5(left.b && right.b && Math.abs(left.h-right.h)<=1, Math.max(left.h, right.h)+1);
        }
        
        return new Pair5(true, 0);
    }
    
    // recursive (n)
    public static boolean isBalancedOpt2(TreeNode root) {
        return isB2(root)>=0;
    }
    
    static int isB2(TreeNode root){
        
        if(root!=null){
            int left = isB2(root.left);
            int right = isB2(root.right);
            
            if(left>=0 && right>=0 && Math.abs(left-right)<=1)
                return Math.max(left, right)+1;
            
            return -1;
        }
        
        return 0;
    }
    
}

class Pair5{
    boolean b;
    int h;
    
    Pair5(boolean b, int h){
        this.b = b;
        this.h=h;
    }
}

