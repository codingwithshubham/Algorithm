package tree.bst;
/*
 * sorted array to bst
 */
public class Q8 {

	public TreeNode sortedArrayToBST(int[] nums) {
        return construct(0, nums.length-1, nums);
    }
    
    TreeNode construct(int start, int end, int[] arr){
        
        if(start>end)
            return null;
        
        int mid = start + (end-start)/2;
        
        TreeNode node = new TreeNode(arr[mid]);
        node.left = construct(start, mid-1, arr);
        node.right = construct(mid+1, end, arr);
        
        return node;
    }
}
