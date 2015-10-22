/**
 * LinkedList Implementation
 */
package List;

import List.Node;

/**
 * @author prakashn
 *
 */
public class LinkedList<Type> {
	private Node<Type> head; //pointer to front
	private Node<Type> tail; //pointer to tail
	int size;
	/**
	 * @param args
	 */
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	
	/*
	 * add to LinkedList
	 */
	public void add(Type data) {
		if(head == null) {
			head = tail = new Node(data);
			size = 1;
			return;
		}
		Node<Type> newNode = new Node(data);
		tail.setNext(newNode);
		newNode.setPrev(tail);
		tail = newNode;
		size++;
		return;
	}
	
	/*
	 * delete a node from first and return that node
	 */
	public Node delete() {
		if(head == null) {
			return null;
		}
		Node temp = head;
		head = head.getNext();
		size--;
		return temp;
	}
	
	/*
	 * delete a value from LinkedList
	 */
	public Node delete(Type data) {
		if(head == null) {
			return null;
		}
		Node cur = head;
		while(cur != null) {
			if(cur.getValue().equals(data)) {
				break;
			}
			cur = cur.getNext();
		}
		if(cur == null) {
			//value is not found
			return null;
		}
		if(cur.getPrev() != null) {
			cur.getPrev().setNext(cur.getNext());
		}
		if(cur.getNext() != null) {
			cur.getNext().setPrev(cur.getPrev());
		}
		return cur;
	}
	
	/*
	 * get the size of the linkedlist
	 * 
	 */
	public int size() {
		return size;
	}
	
	/*
	 * is the linkedlist empty
	 */
	public Boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * display LinkedList
	 */
	public void display() {
		Node cur = head;
		while(cur != null) {
			System.out.print(cur.getValue());
			if(cur.getNext() != null) {
	 			System.out.print(" -> ");
			}
			cur = cur.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.display();
		ll.delete(2);
		ll.display();
		ll.delete();
		ll.display();
	}

}
