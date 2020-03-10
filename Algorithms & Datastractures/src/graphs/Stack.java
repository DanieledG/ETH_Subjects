package graphs;

public class Stack {
	StackNode top;
	int size;
	
	void push(StackNode n) {
		if (size == 0) {
			top = n;
		}
		else {
			n.prev = top;
			top = n;
		}
		size++;
	}
	
	StackNode pop() {
		StackNode temp = top;
		top = top.prev;
		size--;
		return temp;
	}
}
class StackNode{
	StackNode prev;
	Node twin;
	int key;
	
	public StackNode() {}
	
	public StackNode(Node t) {
		key = t.number;
		twin = t;
	}
}
