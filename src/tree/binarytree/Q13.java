package tree.binarytree;

/*
 * check if tree is mirror of other bt
 */
public class Q13 {
	 public static boolean isMirror(TreeNode root1, TreeNode root2){
	        
	        if(root1 == null && root2 == null)
	            return true;
	        if(root1 == null || root2 == null)
	            return false;
	        
	        if(root1.data!=root2.data)
	            return false;
	        
	        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	        
	        
	    }
	
	//iterative
	public static boolean isMirror2(TreeNode root1, TreeNode root2){
        
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        
        queue1.offer(root1);
        queue2.offer(root2);
        
        
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode n1 = queue1.poll();
            TreeNode n2 = queue2.poll();
            
            if(n1 == null || n2==null){
                if(n1!=n2)
                    return false;
            }
            else{
                if(n1.val!=n2.val)
                    return false;
                
                queue1.offer(n1.left);
                queue1.offer(n1.right);
                
                queue2.offer(n2.right);
                queue2.offer(n2.left);
                
                
            }
                
        }
        
        if(!queue1.isEmpty() || !queue2.isEmpty())
            return false;
        
        return true;
        
        
    }

}
