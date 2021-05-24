package tree;
import java.util.*;
/*
 * print ancestor of binary tree
 */
public class Q14 {
	
	//recursive
	public static ArrayList<Integer> Ancestors(TreeNode root, int target){
      
        ArrayList<Integer> list = new ArrayList<>();
        print(root, target, list);
        return list;

    }
    
    static boolean print(TreeNode root, int target, ArrayList<Integer> list){
        
        if(root!=null){
            if(root.data == target)
                return true;
            
            if(print(root.left, target, list) || print(root.right, target, list)){
                list.add(root.data);
                return true;
            }
        }
        
            
        return false;
            
    }
	
	//iterative
	public static ArrayList<Integer> Ancestors1(TreeNode root, int target)
    {
        // add your code here
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> states = new Stack<>();
        
        stack.push(root);
        states.push(0);
        
        while(!stack.isEmpty()){
            int state = states.pop();
            state++;
            states.push(state);
            
            if(state == 1){
                if(stack.peek().left!=null){
                    if(stack.peek().left.data == target)
                        break;
                        
                    stack.push(stack.peek().left);
                    states.push(0);
                }
            }
            else if(state == 2){
                if(stack.peek().right!=null){
                    if(stack.peek().right.data == target)
                        break;
                        
                    stack.push(stack.peek().right);
                    states.push(0);
                }
                
            }
            else{
         
                stack.pop();
                states.pop();
            }
        }
    
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop().data);
        }
        
        return list;
    }

}
