package sorting;

public class MinHeap extends Heap{
	@Override
	public void restoreHeapCondition(IntNode n) {
		IntNode current = n;
		if (current == root) {
			while ((current.left != null) && (current.right != null) 
 					&& ((current.key > current.right.key) 
 					|| (current.key > current.left.key))) {
 				if (current.right.key > current.left.key) {
					swapKeys(current, current.left);
 					current = current.left;
 				}
 				else {
					swapKeys(current, current.right);
 					current = current.right;
				}
 			}
 			if (current.right == null && current.left != null) {
 				if (current.left.key < current.key) {
				swapKeys(current, current.left);
 				}
			}
			if (current.right != null && current.left==null) {
				swapKeys(current, current.right);

 			}
 		}
 		else {
	   		while (current.parent != null && current.key < current.parent.key) {
				swapKeys(current, current.parent);
	   			current = current.parent;
	   		}
 		}
		if (!checkHeapCondition(current)) {
			System.out.println("ERROR MINHEAP");
		}
 	}

	public boolean checkHeapCondition(IntNode n) {
 		if (n.left == null && n.right == null) {
 			return true;
 		}
 		else if (n.left == null) { 
 			return n.right.key >= n.key && checkHeapCondition(n.right);
 		}
		else if (n.right == null) {
 			return n.left.key >= n.key && checkHeapCondition(n.left);
		}
 		else {
 			checkHeapCondition(n.left);
			checkHeapCondition(n.right);
			return n.left.key >= n.key && n.right.key >= n.key;
		}
 	}
}
