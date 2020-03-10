package sorting;

public class IntNode {
	public int key;
	public int balance;
	public int children;
	public IntNode right;
	public IntNode left;
	public IntNode parent;
		
	IntNode() {
		key = 0;
		right = null;
		left = null;
		parent = null;
		balance = 0;
		children = 0;
	}
	
	public IntNode(int key) {
		this.key = key;
		right = null;
		left = null;
		parent = null;
		balance = 0;
		children = 0;
	}
}
