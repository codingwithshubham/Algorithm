package tree.bst;
/*
 * find max
 */
public class Q4 {

	int maxValue(TreeNode node){
        if(node == null)
            return -1;
            
        while(node.right!=null)
            node = node.right;
            
        return node.data;
    }
}
