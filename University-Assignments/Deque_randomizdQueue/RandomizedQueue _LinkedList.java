import java.util.*;

//import Queue.Node;
/**
 * A <tt>randomized queue</tt> is similar to a stack or queue, 
 * except that the item removed is chosen uniformly 
 * at random from items in the data structure.
 * <p>
 * This implementation uses a doubly-linked list with a static nested class for
 *  linked-list nodes. 
 *  The <em>enqueue</em> and <em>dequeue</em> ,<em>sample</em>
 *  operation all take constant time in the worst case.
 *  <p>
 *  
 * @author Prakash
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private int N;
	private Node<Item> first;
	private Node<Item> last;
	
	private static class Node<Item>{
		private Item item;
		private Node<Item> prev;
		private Node<Item> next;
	}
	public RandomizedQueue() { // construct an empty randomized queue
		first = null;
		last  = null;
		N = 0;
	}
	
              
	/**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return N == 0;
    }
    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return N;     
    }
    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
    public void enqueue(Item item)     {      
    	//Throw a NullPointerException if the client attempts to add a null item;
    	if (item == null) throw new NullPointerException(); 
    	Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }
    /**
     * delete and item randomly from the queue
     * @return return the deleted item
     */
   public Item dequeue()   {                 // delete and return a random item
    	if (isEmpty()) throw new NoSuchElementException("Queue underflow");
//    	Random randomno = new Random();
    	Random rand = new Random();
    	int randnbr = rand.nextInt(N);
    	//int randnbr = java.util.Random.nextInt(N);
    	Node<Item> current;
    	Node<Item> newcurrent;
		current = first;
    	int i = 0;
    	Item item;
    	// to check if the random number is the last item
    	if( randnbr != N-1){
	    	while ( i < randnbr){
	    		current= current.next;
	    		i++;
	    	} 
    	
	    	newcurrent = current.next;
			newcurrent.prev=current.prev;
			current.prev.next=newcurrent;
			current.next=null;
			current.prev=null;
			item=current.item;
			N--;
    	}
    	else{	// randnbr points to the last item
    		current = last;
    		last 	= last.prev;
    		item	= current.item;
    		current.prev = null;
    		last.next	 = null;
    		
    	}
    	return item;	
		// case where randnbr is last item
		/**   for loop seems tobe bad implementations
    	for ( i = 0; i <= randnbr; i++){
    		if (  (i != randnbr )){
    			current= current.next;
    		}
    		newcurrent = current.next;
    		newcurrent.prev=current.prev;
    		current.prev.next=newcurrent;
    		current.next=null;
    		current.prev=null;
    		Item item=current.item;
    		*/
    	}
   /**
    * return (but do not delete) a random item
    * @return randomly select and return the item without deleting
    */
   public Item sample()  {                   
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Random rand = new Random();
	   	int randnbr = rand.nextInt(N);
	   	Node<Item> current;
	   	
	   	current = first;
	   	int j = 0;
	   	Item item;
	   	// to check if the random number is the last item
	   	if( randnbr != N-1){
	    	while ( j < randnbr){
	    		current= current.next;
	    		j++;
	    	} 
	    	item=current.item;
			//N--;   we are not deleting any item, so no need to deduct N
	   	}
	   	else{	// randnbr points to the last item
	   		item	= last.item;
	   	}
	   	return item;	
   }
   public Iterator<Item> iterator()   {      // return an independent iterator over items in random order
	   return new ListIterator<Item>(first);
   }
   // an iterator, doesn't implement remove() since it's optional
   @SuppressWarnings("hiding")
   private class ListIterator<Item> implements Iterator<Item> {
       private Node<Item> current;

       public ListIterator(Node<Item> first) {
           current = first;
       }
       public boolean hasNext()  { return current != null;                     }
       public void remove()      { throw new UnsupportedOperationException();  }
       public Item next() {
           if (!hasNext()) throw new NoSuchElementException();
           Item item = current.item;
           current = current.next; 
           return item;
       }
   }
// unit testing
   public static void main(String[] args) {
	   RandomizedQueue<String> rq = new RandomizedQueue<String>();
		rq.enqueue("prakash1");
		rq.enqueue("yoga1");
		rq.enqueue("santhosh1");
		rq.enqueue("yoga2");
		rq.enqueue("santhosh2");
		rq.enqueue("prakash2");
		StdOut.println("Items in Queue\n-------------");
		for(String s : rq){
			StdOut.println(s);
		}
		StdOut.println("Random Sample : \t" + rq.sample());
   }
}
