import java.util.LinkedList;
import java.util.Queue;
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
	
	
	public int BFSiterativeMaxDepth(Node root) {
	    if(root == null) {
	        return 0;
	    }
	    Queue<Node> queue = new LinkedList<>();
	    queue.offer(root);
	    int count = 0;
	    while(!queue.isEmpty()) {
	        int size = queue.size();
	        while(size-- > 0) {
	        	Node node = queue.poll();
	            if(node.left != null) {
	                queue.offer(node.left);
	            }
	            if(node.right != null) {
	                queue.offer(node.right);
	            }
	        }
	        count++;
	    }
	    return count;
	}
	
	/*
	 * Compute the "maxDepth" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int recursiveMaxDepth(Node node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = recursiveMaxDepth(node.left);
			int rDepth = recursiveMaxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	// returns true if trees with roots as root1 and root2 are mirror
	public boolean isMirror(Node node1, Node node2) {
		// if both trees are empty, then they are mirror image
		if (node1 == null && node2 == null)
			return true;

		// For two trees to be mirror images, the following three
		// conditions must be true
		// 1 - Their root node's key must be same
		// 2 - left subtree of left tree and right subtree
		// of right tree have to be mirror images
		// 3 - right subtree of left tree and left subtree
		// of right tree have to be mirror images
		if (node1 != null && node2 != null && node1.key == node2.key)
			return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));

		// if neither of the above conditions is true then
		// root1 and root2 are mirror images
		return false;
	}

	// returns true if the tree is symmetric i.e
	// mirror image of itself
	public boolean recursiveIsSymmetric(Node node) {
		// check if tree is mirror of itself
		return isMirror(root, root);
	}

	/* function to check if the tree is Symmetric */
	public boolean iterativeIsSymmetric(Node root) {
		/* This allows adding null elements to the queue */
		Queue<Node> q = new LinkedList<Node>();

		/* Initially, add left and right nodes of root */
		q.add(root.left);
		q.add(root.right);

		while (!q.isEmpty()) {
			/*
			 * remove the front 2 nodes to check for equality
			 */
			Node tempLeft = q.remove();
			Node tempRight = q.remove();

			/*
			 * if both are null, continue and chcek for further elements
			 */
			if (tempLeft == null && tempRight == null)
				continue;

			/* if only one is null---inequality, retun false */
			if ((tempLeft == null && tempRight != null) || (tempLeft != null && tempRight == null))
				return false;

			/*
			 * if both left and right nodes exist, but have different values-- inequality,
			 * return false
			 */
			if (tempLeft.key != tempRight.key)
				return false;

			/*
			 * Note the order of insertion of elements to the queue : 1) left child of left
			 * subtree 2) right child of right subtree 3) right child of left subtree 4)
			 * left child of right subtree
			 */
			q.add(tempLeft.left);
			q.add(tempRight.right);
			q.add(tempLeft.right);
			q.add(tempRight.left);
		}

		/* if the flow reaches here, return true */
		return true;
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(3);
		boolean output = tree.recursiveIsSymmetric(tree.root);
		if (output == true)
			System.out.println("The given tree is Symmetric");
		else
			System.out.println("The given tree is not Symmetric");
		output = tree.iterativeIsSymmetric(tree.root);
		if (output == true)
			System.out.println("The given tree is Symmetric");
		else
			System.out.println("The given tree is not Symmetric");
        System.out.println("Height of tree is : " +  
                tree.recursiveMaxDepth(tree.root)); 
        System.out.println("Height of tree is : " +  
                tree.BFSiterativeMaxDepth(tree.root));
        System.out.println("Height of tree is : " +  
                tree.DFSiterativeMaxDepth(tree.root));
	}
}
