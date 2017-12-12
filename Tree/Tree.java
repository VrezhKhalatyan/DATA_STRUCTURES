package homework4final;

import java.util.ArrayList;

public class Tree {
	static final boolean RED = true;
	static final boolean BLACK = false;

	class Node {
		public int val;
		Node left;
		Node right;
		boolean color;
		private int size;

		public Node(int val, boolean color, int size) {
			this.val = val;
			this.color = color;
			this.size = size;
		}

		public String toString() {
			return "" + val;
		}
	}

	private Node colorFlip(Node x) {
		x.color = !x.color;
		x.left.color = !x.left.color;
		x.right.color = !x.right.color;
		return x;
	}

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = x.left.color;
		x.left.color = RED;
		return x;
	}

	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = x.right.color;
		x.right.color = RED;
		return x;
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		return x.size;
	}

	public int size() {
		return size(root);
	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return (x.color == RED);
	}

	void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node + " ");
		inOrder(node.right);
	}

	void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node + " ");
	}

	Node insert(Node h, int val, int size) {
		if (h == null) {
			return new Node(val, RED, size);
		}
		if (isRed(h.left) && isRed(h.right)) {
			colorFlip(h);
		}
		int cmp = val - h.val;
		if (cmp == 0) {
			h.val = val;
		} else if (cmp < 0) {
			h.left = insert(h.left, val, size);
		} else {
			h.right = insert(h.right, val, size);
		}
		if (isRed(h.right)) {
			h = rotateLeft(h);
		}
		if (isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h);
		}
		return h;
	}

	Node root = insert(null, 1, 0);

	private Node remove(Node h, Integer val) {
		
		if (root == null)
			return h;

		Node parent = null;
		Node current = root;
		while (current != null) {
			if (val < current.val) {
				parent = current;
				current = current.left;
			} else if (val.compareTo(current.val) > 0) {
				parent = current;
				current = current.right;
			} else
				break;
		}
		if (current == null)
			return h;
		if (current.left == null) {
			if (parent == null) {
				root = current.right;
			} else {
				if (val.compareTo(parent.val) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
			if (isRed(h.right))
				h = rotateLeft(h);
			if (isRed(h.left) && isRed(h.left.left))
				h = rotateRight(h);
			if (isRed(h.left) && isRed(h.right))
				colorFlip(h);
			h.size = size(h.left) + size(h.right) + 1;
		} else {
			Node parentOfRightMost = current;
			Node rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			current.val = rightMost.val;
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				parentOfRightMost.left = rightMost.left;
			if (isRed(h.right))
				h = rotateLeft(h);
			if (isRed(h.left) && isRed(h.left.left))
				h = rotateRight(h);
			if (isRed(h.left) && isRed(h.right))
				colorFlip(h);
			h.size = size(h.left) + size(h.right) + 1;
		}
		return h;
	}

	private int rand(int min, int max) {
		int a = (int) (Math.random() * max + min);
		return a;
	}

	public static void main(String args[]) {
		new Tree().run();
	}

	public void run() {
		//Node root = insert(null, 1, 0);
		ArrayList<Integer> tracker = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			final int n = rand(1, 100);
			tracker.add(n);
			root = insert(root, n, n);
		}
		System.out.println("preorder: ");
		preOrder(root);
		System.out.println("");
		System.out.println("postorder: ");
		postOrder(root);
		System.out.println("");
		System.out.println("inorder: ");
		inOrder(root);
		System.out.println("");
		
		System.out.println("");
		for (Integer n : tracker) {
			root = remove(root, n);
			System.out.println("Removing: " + n);
			inOrder(root);
			System.out.println("");
		}
	}
}
