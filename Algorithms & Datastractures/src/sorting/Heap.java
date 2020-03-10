package sorting;

import java.util.Arrays;

public class Heap {
	public IntNode root;
	IntNode lastInserted;
	int size;
	int height;
	boolean[] wayToLeaf;	//an array that saves the way to the first empty leaf, false means left and true means right
		
		public Heap() {	//basic constructor 
		height = 0;
		root = null;
		size = 0;
		wayToLeaf = null;
		lastInserted = null;
		}
		
		public int[] heapsort(int[] A) {
			for (int i = 0; i < A.length; i++) {
				insert(A[i]);
			}
			for (int i = A.length-1; i >= 0; i--) {
				A[i] = extractRoot();
			}
			return A;
		}
		   		
		public void wayToLeaf() {
			if (isAllTrue()) {
				wayToLeaf = new boolean[height];
			}
			else {
				int i = wayToLeaf.length - 1;
				while (wayToLeaf[i]) {				//look for the last left turn
					i--;
				}
				wayToLeaf[i] = true;				//make it a right turn
				for (int j = i + 1; j < wayToLeaf.length; j++) {
					wayToLeaf[j] = false;			//and all that's below him a left;
				}
			}
		}
		
		public void wayToPreviousLeaf() {
			if (isAllFalse()) {
				wayToLeaf = new boolean[height-1];
				Arrays.fill(wayToLeaf, true);
				for (int i = 0; i < wayToLeaf.length; i++) {
					wayToLeaf[i] = true;
				}
			}
			else {
				int i = wayToLeaf.length - 1;
				while (!wayToLeaf[i]) {				//look for the last right turn
					i--;
				}
				wayToLeaf[i] = false;				//make it a left turn
				for (int j = i+1; j < wayToLeaf.length; j++) {
					wayToLeaf[j] = true;			//and all that's below him a right;
				}
			}
	}
		public boolean isAllTrue() {
		for (int i = 0; i < wayToLeaf.length; i++) {
				if (!wayToLeaf[i]) {
					return false;
				}
			}
			return true;
		}
	
		
		public boolean isAllFalse() {
			for (int i = 0; i < wayToLeaf.length; i++) {
			if (wayToLeaf[i]) {
					return false;
			}
			}
			return true;
		}
		
	public int extractRoot() {
		int key = root.key;
		if (size == 1) {
   			height = 0;
	   		root = null;
			size = 0;   
	  	}
		else {
			swapKeys(lastInserted, root);
			if (lastInserted == lastInserted.parent.left) {
				lastInserted.parent.left = null;
			}
			else {
				lastInserted.parent.right = null;
			}
			size--;
			
			refreshLastInserted();
			restoreHeapCondition(root);
		}
		return key;
	}
	
	public void refreshLastInserted() {
		wayToPreviousLeaf();
		if (isAllFalse()) {
			height--;
		}
		wayToPreviousLeaf();
		IntNode current = root;
		IntNode parent = null;
		for (int i = 0; i < wayToLeaf.length; i++) {
			if (i == wayToLeaf.length - 1) {	//if it's the last operation
				parent = current;				//we remember the parent node
			}
			if (wayToLeaf[i]) {
				current = current.right;
			}
			else {
				current = current.left;
			}
		}
		lastInserted = current;
		lastInserted.parent = parent;
		lastInserted.left = null;
		lastInserted.right = null;
		wayToLeaf();
		}
		
		public void restoreHeapCondition(IntNode n) {
		//just to make Eclipse happy	
		}

		public void insert(int key) {
		if (size == 0) {
				root = new IntNode(key);
			size = 1;
				height = 1;
			}
		else if (size == 1) {
			root.left = new IntNode(key);
			root.left.parent = root;
			size = 2;
			height = 2;
			wayToLeaf = new boolean[1];
			wayToLeaf[0] = true;
			lastInserted = root.left;
			restoreHeapCondition(root.left);
		}
		else {
			IntNode current = root;
			IntNode parent = null;
			for (int i = 0; i < wayToLeaf.length; i++) {
				if (i == wayToLeaf.length - 1) {	//if it's the last operation
					parent = current;				//we remember the parent node
				}
				if (wayToLeaf[i]) {
					current = current.right;
				}
				else {
					current = current.left;
				}
			}
			
			if(wayToLeaf[wayToLeaf.length-1]) {
				parent.right = new IntNode(key);
				current = parent.right;
			}
			else {
				parent.left = new IntNode(key);
				current = parent.left;
			}
			current.parent = parent;
			lastInserted = current;
			size++;
				
			if (isAllFalse()) {
				height++;
			}
			wayToLeaf();
			restoreHeapCondition(current);	  
			}
		}
		
		public void swapKeys(IntNode n, IntNode m) {
		n.key += m.key;
		m.key = n.key - m.key;
		n.key -= m.key;
	}
}
