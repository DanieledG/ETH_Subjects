package sorting;

import java.util.ArrayList;

public class AVLTree {
	int size;
	public IntNode root;
	public ArrayList<Integer> inOrder;
	boolean rotation;
	
	public AVLTree() {
		size = 0;
		root = null;
	}
	
	public void insert(int key) {
		if (size == 0) {
			root = new IntNode(key);
			size = 1;
			inOrder = new ArrayList<Integer>();
		}
		else {
			IntNode parent = searchInsert(key);
			IntNode newNode = new IntNode(key);
			
			if (parent == null) {
				System.out.println("key already present in tree");
			}
			else {
				rotation = false;
				newNode.parent = parent;
				if (parent.key < key) {
					parent.right = newNode;
					parent.balance++;
				}
				else {
					parent.left = newNode;
					parent.balance--;
				}
				size++;
			
				if (parent.balance != 0) {
					upin(parent);
				}
				if(rotation) {
					int s = adjChildren(root);
					if (s != size-1) {
						System.out.println("porco Dio");
					}
				}
				else {
					parent.children++;
					IntNode current = parent;
					while(current.parent != null) {
						current.parent.children++;
						current = current.parent;
					}	
				}
				if (!checkAVLcondition(parent)) {
					System.out.println("porco Dio");
				}
			}
		}
	}
	
	public void delete(int key) {
		IntNode current = root;

		while (current!=null) {
			if (current.key < key) {
				current = current.right;
			}
			else if (current.key > key) {
				current = current.left;
			}
			else {
				IntNode SS = symmetricSuccessor(current);
				rotation = false;
				if(SS == null) {
					SS = current;
				}
				current.key = SS.key;
				if(SS.parent.left.equals(SS)) {
					SS.parent.left = null;
				}
				else {
					SS.parent.right = null;
				}
				upin(SS.parent);
				adjChildren(root);
			}
		}
	}
	
	public IntNode symmetricSuccessor(IntNode n) {
		IntNode parent = n;
		IntNode current = n.right;
		if (current == null) {
			return n.left;
		}
		while (current!=null) {
			parent = current;
			current = current.left;
		}
		return parent;
	}
	
	public int adjChildren(IntNode node) {
		if(node.left == null && node.right == null) {
			node.children = 0;
		}
		else if (node.left != null && node.right != null){
			node.children = 2 + adjChildren(node.left) + adjChildren(node.right);
		}
		else if (node.left != null){
			node.children = 1 + adjChildren(node.left);
		}
		else {
			node.children = 1 + adjChildren(node.right);
		}
		return node.children;
	}
	
	public void upin(IntNode node) {
		if (node.parent != null) {
			if (node == node.parent.right) {
				if (node.parent.balance == 1) {
					if (node.balance == 1) {
						leftRotation(node, node.parent);
						rotation = true;
					}
					else {
						rightRotation(node.left, node);
						leftRotation(node.parent, node.parent.parent);
						rotation = true;
					}
				} 
				else if (node.parent.balance == 0){
					node.parent.balance++;
					upin(node.parent);
				}
				else {
					node.parent.balance++;
				}
			} 
			else {
				if (node.parent.balance == -1) {
					if (node.balance == 1) {
						leftRotation(node.right, node);
						rightRotation(node.parent, node.parent.parent);
						rotation = true;
					}
					else {
						rightRotation(node, node.parent);
						rotation = true;
					}
				} 
				else if (node.parent.balance == 0){
					node.parent.balance--;
					upin(node.parent);
				}
				else {
					node.parent.balance--;
				}
			}
		}
	}
	
	public IntNode searchInsert(int key) {
		IntNode current = null;
		IntNode parent = root;
		if (root.key < key) {
			current = root.right;
		}
		else if (root.key > key) {
			current = root.left;
		}
		else {
			return null;
		}
		while (current!=null) {
			parent = current;
			if (current.key < key) {
				current = current.right;
			}
			else if (current.key > key) {
				current = current.left;
			}
			else {
				return null;
			}
		}
		return parent;
	}
	
	public boolean checkAVLcondition(IntNode node) {
		for (IntNode current = node; current != null; current = current.parent) {
			if( Math.abs(current.balance) > 1) {
				return false;
			}
		}
		return true;
	}

	public void leftRotation(IntNode node, IntNode other) {
		IntNode left = node.left;
		other.right = left;
		if (left != null) {
			left.parent = other;
		}
		node.left = other;
		node.parent = other.parent;
		if (other == root) {
			root = node;
		}
		else {
			if (other.parent.right == other) {
				other.parent.right = node;
			}
			else {
				other.parent.left = node;
			}
		}
		other.parent = node;
		node.balance = 0;
		other.balance = 0;
	}
	
	public void rightRotation(IntNode node, IntNode other) {
		IntNode right = node.right;
		other.left = right;
		if (right!= null) {
			right.parent = other;
		}
		node.right = other;
		node.parent = other.parent;
		if (other == root) {
			root = node;
		}
		else {
			if (other.parent.right == other) {
				other.parent.right = node;
			}
			else {
				other.parent.left = node;
			}
		}
		other.parent = node;
		node.balance = 0;
		other.balance = 0;
	}
	
	public void inOrder(IntNode node) {
		if (node != null) {
			inOrder(node.left);
			inOrder.add(node.key);
			inOrder(node.right);
		}
	}

	public int rank(int x) {
		IntNode current = root;
		int count = 0;
		while(current != null) {
			if (current.key == x) {
				if (current.left != null) {
					count += 2 + current.left.children;
				}
				else {
					count++;
				}
				return count;
			}
			else if (current.key < x) {
				if (current.left != null) {
					count += 2 + current.left.children;
				}
				else {
					count++;
				}
				current = current.right;
			}
			else {
				current = current.left;
			}
		}
		return count;
	}
}