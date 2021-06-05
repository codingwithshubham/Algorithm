package tree.bst;
/*
 *  kth smallest
 */
public class Q9 {

	int pos = 0;
	
	//recursive    O(K)
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        
        int left = kthSmallest(root.left, k);
        if(left>=0)
            return left;
        else{
            pos++;
            
            if(pos == k)
                return root.data;
            else
                return kthSmallest(root.right, k);
        }
    }
    
    // iterative just use inorder traversal and use break after k
    
    //o(H)
    public int kthSmallest1(Node node, int k) {
    	if(node == null)
    		return -1;
    	
    	int count = node.left_count+1;
    	
    	if(k==count)
    		return node.data;
    	else if(k<count)
    		return kthSmallest1(node.left, k);
    	else
    		return kthSmallest1(node.right, k-count);
    }
    
    // function to insert node with count of left subtree nodes
    Node insertNode(Node root, int val) {
    	
    	if(root == null)
    		return new Node(val);
    	
    	if(val<root.data) {
    		root.left_count++;
    		root.left = insertNode(root.left, val);
    	}
    	else
    		root.right = insertNode(root.right, val);
    	
    	return root;
    }
     
}

class Node{
	int data;
	int left_count;
	
	Node left, right;
	
	public Node(int data){
		this.data = data;
	}
}
