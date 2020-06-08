import java.util.*;

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

public List<String> binaryTreePaths(Node root) {

        List<String> paths = new LinkedList<>();

        if(root == null) return paths;

        if(root.left == null && root.right == null){
            paths.add(root.key+"");
            return paths;
        }

         for (String path : binaryTreePaths(root.left)) {
             paths.add(root.key + "->" + path);
         }

         for (String path : binaryTreePaths(root.right)) {
             paths.add(root.key + "->" + path);
         }

         return paths;

    }



public List<String> binaryTreePaths() {
	return binaryTreePaths(root);
}

public List <Double> DFSaverageOfLevels(Node root) {
    List <Integer> count = new ArrayList <> ();
    List <Double> res = new ArrayList <> ();
    average(root, 0, res, count);
    for (int i = 0; i < res.size(); i++)
        res.set(i, res.get(i) / count.get(i));
    return res;
}
public void average(Node t, int i, List <Double> sum, List <Integer> count) {
    if (t == null)
        return;
    if (i < sum.size()) {
        sum.set(i, sum.get(i) + t.key);
        count.set(i, count.get(i) + 1);
    } else {
        sum.add(1.0 * t.key);
        count.add(1);
    }
    average(t.left, i + 1, sum, count);
    average(t.right, i + 1, sum, count);
}

public List < Double > BFSaverageOfLevels(Node root) {
    List <Double> res = new ArrayList <> ();
    Queue <Node> queue = new LinkedList <> ();
    queue.add(root);
    while (!queue.isEmpty()) {
        long sum = 0, count = 0;
        Queue <Node> temp = new LinkedList <> ();
        while (!queue.isEmpty()) {
        	Node n = queue.remove();
            sum += n.key;
            count++;
            if (n.left != null)
                temp.add(n.left);
            if (n.right != null)
                temp.add(n.right);
        }
        queue = temp;
        res.add(sum * 1.0 / count);
    }
    return res;
}


public List<Double> averageOfLevels() {
	return DFSaverageOfLevels(root);
	// return BFSaverageOfLevels(root);
}


	public static void main(String args[]) {
		BinaryTree tree1 = new BinaryTree();
		tree1.root = new Node(3);
		tree1.root.left = new Node(9);
		tree1.root.right = new Node(20);
		tree1.root.right.left = new Node(15);
		tree1.root.right.right = new Node(7);

		System.out.println(tree1.binaryTreePaths());
		System.out.println(tree1.averageOfLevels());

	}
}
