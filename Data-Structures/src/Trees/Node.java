package Trees;

public class Node<Key extends Comparable<Key>, Value> {
	Key key;
	Value val;
	Node left;
	Node right;
	int N;
	
	public Node(Key k, Node l, Node r) {
		key = k;
		left = l;
		right = r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
