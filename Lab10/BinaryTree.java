import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class BinaryTree {
	public Node root;
	public static class Node {
	public int key;
	public Node left, right;
		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	public boolean isBalanced(Node root) {
	// place your code here
		if(root==null)
			return true;
		else{
			int lefth  = DFSiterativeMaxDepth(root.left);
			int righth = DFSiterativeMaxDepth(root.right);
			if(Math.abs(lefth-righth)<=1)
				return isBalanced(root.left)&&isBalanced(root.right);
			else
				return false;
		}
	}
	
	public int DFSiterativeMaxDepth(Node root) {
	    if(root == null) {
	        return 0;
	    }
	    
	    Stack<Node> stack = new Stack<>();
	    Stack<Integer> value = new Stack<>();
	    stack.push(root);
	    value.push(1);
	    int max = 0;
	    while(!stack.isEmpty()) {
	    	Node node = stack.pop();
	        int temp = value.pop();
	        max = Math.max(temp, max);
	        if(node.left != null) {
	            stack.push(node.left);
	            value.push(temp+1);
	        }
	        if(node.right != null) {
	            stack.push(node.right);
	            value.push(temp+1);
	        }
	    }
	    return max;
	}
	
	public boolean isBalanced() {
		return isBalanced(root);
	}
	public static void main(String args[]) {
		BinaryTree tree1 = new BinaryTree();
		tree1.root = new Node(3);
		tree1.root.left = new Node(9);
		tree1.root.right = new Node(20);
		tree1.root.right.left = new Node(15);
		tree1.root.right.right = new Node(7);
		BinaryTree tree2 = new BinaryTree();
		tree2.root = new Node(1);
		tree2.root.left = new Node(2);
		tree2.root.right = new Node(2);
		tree2.root.left.left = new Node(3);
		tree2.root.left.right = new Node(3);
		tree2.root.left.left.left = new Node(4);
		tree2.root.left.left.right = new Node(4);
		System.out.println(tree1.isBalanced());
		System.out.println(tree2.isBalanced());
		BinaryTree tree3 = new BinaryTree();
		tree3.root = new Node(1);
		tree3.root.left = new Node(2);
		tree3.root.right = new Node(2);
		tree3.root.left.left = new Node(3);
		tree3.root.right.right = new Node(3);
		tree3.root.left.left.left = new Node(3);
		tree3.root.right.right.right = new Node(3);
		System.out.println(tree3.isBalanced());
	}
}
