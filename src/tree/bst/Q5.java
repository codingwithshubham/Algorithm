package tree.bst;
/*
 * find min
 */
public class Q5 {

	int minValue(TreeNode node){
        if(node == null)
            return -1;
            
        while(node.left!=null)
            node = node.left;
            
        return node.data;
    }
}
