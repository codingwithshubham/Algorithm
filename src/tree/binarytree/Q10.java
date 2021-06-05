package tree.binarytree;
import java.util.*;
/*
 * print all path of binary tree
 */
public class Q10 {
	//recursive
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        int[] arr = new int[100];
        print(root, arr, 0, list);
        
        return list;
    }
    
	static void print(TreeNode root, int[] arr, int level, List<String> list){
        
        if(root!=null){
            arr[level] = root.data;
            
            if(root.left==null && root.right==null){
                String s = "";
                for(int i=0; i<level; i++){
                    s += arr[i]+"->";
                }
                s+=arr[level];
                
                list.add(s);
            }
            else{
            	print(root.left, arr, level+1, list);
            	print(root.right, arr, level+1, list);
            }
        }
        
    }
    
	//iterative array based
	public static List<String> binaryTreePaths1(TreeNode root) {
        
        ArrayList<String> list = new ArrayList();
        
        if(root!=null){
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> states = new Stack();
            
            int[] arr = new int[100];
            int level = -1;

            stack.push(root);
            states.push(0);
            
            while(!stack.isEmpty()){
                
                int state = states.pop();
                state++;
                states.push(state);
                
                if(state == 1){
                    
                    level++;
                    arr[level] = stack.peek().data;
                    
                    if(stack.peek().left!=null){
                        stack.push(stack.peek().left);
                        states.push(0);
                    }
                }
                else if(state == 2){
                    if(stack.peek().right!=null){
                        stack.push(stack.peek().right);
                        states.push(0);
                    }
                }
                else{
                    
                    if(stack.peek().left == null && stack.peek().right==null){
                        String s = "";
                        
                        for(int i=0; i<level; i++){
                            s+=arr[i]+"->";
                        }
                        s+=arr[level];
                        
                        list.add(s);
                    }
                    level--;

                    stack.pop();
                    states.pop();
                }
                    
            }
            
           
        }
        
         return list;
        
    }
	
	//iterative
	public static List<String> binaryTreePaths2(TreeNode root) {
        
        ArrayList<String> list = new ArrayList();
        
        if(root!=null){
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> states = new Stack();
            
            LinkedList<Integer> queue = new LinkedList();

            stack.push(root);
            states.push(0);
            
            while(!stack.isEmpty()){
                
                int state = states.pop();
                state++;
                states.push(state);
                
                if(state == 1){
                    queue.offer(stack.peek().data);
                    
                    if(stack.peek().left!=null){
                        stack.push(stack.peek().left);
                        states.push(0);
                    }
                }
                else if(state == 2){
                    if(stack.peek().right!=null){
                        stack.push(stack.peek().right);
                        states.push(0);
                    }
                }
                else{
                    
                    if(stack.peek().left == null && stack.peek().right==null){
                        String s = "";
                        int last = queue.pollLast();
                        Iterator i = queue.iterator();
                        
                        while(i.hasNext()){
                           s+=i.next()+"->"; 
                        }
                        
                        s+=last;
                        
                        list.add(s);
                    }
                    else    
                        queue.pollLast();
                    
                    stack.pop();
                    states.pop();
                }
                    
            }
            
           
        }
        
         return list;
        
    }
}
