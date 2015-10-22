/**
 *  Node for LinkedList manipulation
 */
package List;

/**
 * @author prakashn
 *
 */
public class Node<Value> {

	/**
	 * @param args
	 */
	private Value value;
	private Node next;
	private Node prev;
	
	public Node(Value v) {
		value = v; 
		next = null;
		prev = null;
	}
	public Value getValue() {
		return value;
	}
	public Node getNext() {
		return next;
	}
	
	public Node getPrev() {
		return prev;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
	public void setPrev(Node p) {
		prev = p;
	}
	
	public Node(Value v, Node p, Node n) {
		value = v;
		prev = p;
		next = n;
	}
}
