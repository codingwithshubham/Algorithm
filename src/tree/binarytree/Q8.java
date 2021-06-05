package tree.binarytree;
/*
 * Diameter of binary tree
 */

public class Q8 {
	static int diameter(TreeNode root) {
		
		return dia(root).dia;
	}
	
	static Pair1 dia(TreeNode root) {
		
		if(root!=null) {
			
			Pair1 lpair = dia(root.left);
			Pair1 rpair = dia(root.right);
			
			int height = Math.max(lpair.height, rpair.height)+1;
			int dia = Math.max(Math.max(lpair.dia, rpair.dia), lpair.height+rpair.height+2);
			
			return new Pair1(height, dia);
		}
		
		return new Pair1(-1, 0);
	}

}

class Pair1{
	int height;
	int dia;
	
	Pair1(int height, int dia){
		this.height = height;
		this.dia= dia;
	}
}
