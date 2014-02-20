import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.NullPointerException;
/**
 *  The <tt>Deque</tt> class is a generalization of a stack and a queue that supports 
 *  inserting and removing items from either the front or the back of the data structure
 *  It supports the  <em>addFirst</em> and <em>addLast</em> ,<em>removeFirst</em>, <em>removeLast</em>
 *  operations, along with methods for peeking at the first item,
 *  testing if the queue is empty, and iterating through
 *  the items in FIFO order.
 *  <p>
 *  This implementation uses a doubly-linked list with a static nested class for
 *  linked-list nodes. 
 *  The <em>addFirst</em> and <em>addLast</em> ,<em>removeFirst</em>, <em>removeLast</em>
 *  operation all take constant time in the worst case.
 *  <p>
 *  
 *  @author Prakash Natarajan
 *  @mail prakash.natarajan@outlook.com
 */

public class Deque<Item> implements Iterable<Item> {
    private int N;                // size of the Deque
    private Node<Item> first;     // top of Deque
    private Node<Item> last;     // top of Deque
    
    // helper linked list class
    // contains item value, prev value, next value
    @SuppressWarnings("hiding")
	private class Node<Item> {
        public Item item;
        public Node<Item> next;
        public Node<Item> prev;
        
        public Node(Node<Item> prev, Node<Item> next, Item item) {
        	this.prev = prev;
        	this.next = next;
        	this.item = item;
        }
    }
	
	// construct an empty deque
	public Deque() {
		N=0;
		first=null;
		last=null;
	}
	
	/**
     * Is this deque empty?
     * @return true if this deque is empty; false otherwise
     */                         
   public boolean isEmpty()                 // is the deque empty?
   {
	   return N == 0;
   }
   /**
    * Returns the number of items in the deque.
    * @return the number of items in the deque.
    */
   public int size()                        // return the number of items on the deque
   {
	   return N;
   }
   
   /**
    * adds and element to the front of deque
    * @param item to be inserted
    * @throws NullPointerException when the user attempts to insert and empty value
    */
   public void addFirst(Item item)          // insert the item at the front
   {
	   if (item == null) throw new NullPointerException("Null value is added"); 
	   
	   Node<Item> node = new Node<Item>(null,first,item);
	   if (!isEmpty())
		   first.prev=node;
	   first=node;
	   if (last == null)
		   last = first;
	   N++;
	   
	   /** old code
	   if (first==null && last==null){
		   first.item=item;
		   first.next=null;
		   first.prev=null;
		   first=last;
		   N++;
		   return;
	   }
	   else
	   {
		 Node<Item> oldfirst = first;
		 first = new Node<Item>();
		 first.item = item;
		 first.next = oldfirst;
		 oldfirst.prev = first;
		 first.prev = null;
		 N++;
	   }
	   **/
   }
   /**
    * adds and element to the last of deque
    * @param item
    * @throws NullPointerException when the user attempts to insert and empty value
    */
   public void addLast(Item item)           // insert the item at the end
   {
	   if (item == null) throw new NullPointerException("Null value is added"); 
	   // new code for memory 
	   Node<Item> node = new Node<Item>(last, null, item);
	   if (last != null) last.next = node;
	   
	   last = node;
	   if (isEmpty())
		   first = last;
	   N++;
	   
	   /** oldcode which lacked memory management
	   if(first==null && last==null){
		   first.item=item;
		   first.next=null;
		   first.prev=null;
		   first=last;
		   N++;
		   return;
	   }
	   else
	   {
		   	 Node<Item> oldlast = last;
			 last = new Node<Item>();
			 last.item = item;
			 last.next = null;
			 oldlast.next = last;
			 last.prev = oldlast;
			 N++;
		   
	   }
	   */
   }
   /**
    * remove the first item in the deque
    * @return item which is being removed
    */
   public Item removeFirst()                // delete and return the item at the front
   {
	   if (isEmpty()) throw new NoSuchElementException("Stack underflow");
       Item item = first.item;        // save item to return
       if (first.next != null) first.next.prev = null;
       if (last == first) last = null;
       first = first.next;            // delete first node
       N--;
       return item;                   // return the saved item
   
   }
   /**
    * remove the first item in the deque
    * @return item which is being removed
    */
   public Item removeLast()                 // delete and return the item at the end
   {
	   if (isEmpty()) throw new NoSuchElementException("Stack underflow");
       Item item = last.item;        // save item to return
       if (last.prev != null) last.prev.next = null;
       if (last == first) first = last = null;
       if (last != null)
    	   last = last.prev;            // delete last node
       N--;
       
       return item;                   // return the saved item
   }
   
   /**
    * Returns an iterator that iterates over the items in this queue in FIFO order.
    * @return an iterator that iterates over the items in this queue in FIFO order
    */
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   {
	   //return new ListIterator<Item>(first);
	   return new ListIterator();
   }
   private class ListIterator implements Iterator<Item>
   {
	   private Node<Item> current = first;
	   
//	   public ListIterator() {
//		current = first;
//	   }
	   public boolean hasNext() { return current != null; }
	
	   public Item next() {
		if (!hasNext()){ throw new NoSuchElementException();}
		Item item=current.item ;
		current=current.next;
		return item;
	}
	
	public void remove() {
		//throw an UnsupportedOperationException if the client calls the remove() method in the iterator; 
		throw new UnsupportedOperationException();
	}
   }
   
   public static void main(String[] args)  { // unit testing
	   Deque<String> d= new Deque<String>();
	   		d.addFirst("sant");
	   		d.addLast("prakash");
	   		d.addFirst("sid");
	   		for (String s : d)
	   			StdOut.println(s);
	   		StdOut.println("removing last");
	   		StdOut.println(d.removeLast());
	   		StdOut.println("resulting list");
	   		for (String s : d)
	   			StdOut.println(s);
	   		StdOut.println("removing fist");
	   		StdOut.println(d.removeFirst());
	   		StdOut.println("resulting list");
	   		for (String s : d)
	   			StdOut.println(s);
	   		
	   		
   }

}
