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
 * @mail prakash.natarajan@outlook.com
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] q;
	private int first = 0 ;
	private int last = 0;
	private int N = 0;
	
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue() { // construct an empty randomized queue
		q = (Item[]) new Object[2];
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
     * funtion to resize the array
     * @param capacity which needs to be extended
     * @return void
     */
    @SuppressWarnings("unchecked")
	private void resize(int capacity)
    {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < N; i++)
    copy[i] = q[i];
    q = copy;
    first = 0;
    last = N;
    }
    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
    public void enqueue(Item item)     {      
    	//Throw a NullPointerException if the client attempts to add a null item;
    	if (item == null) throw new NullPointerException(); 
    	
    	if (N == q.length) 
    		resize(2 * q.length);
    	q[last++] = item;
    	if (last == q.length) last = 0; // avoid index array out of bounds
    	N++; 
    	/**  old linked list implementation
    	Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
        */
    }
    /**
     * delete and item randomly from the queue
     * @return return the deleted item
     */
   public Item dequeue()   {                 // delete and return a random item
    	if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    	
    	int randnbr = (first + StdRandom.uniform(N)) % q.length;
    	Item item = q[randnbr]; 
    	q[randnbr] = q[first];
    	q[first] = null;	// to avoid loitering 
    	N--;
    	first++;
    	if (first == q.length) first = 0; //reindexing first
    	// resize array depending on the size
    	if (N > 0 && N == q.length/4)
    		resize(q.length/2);	//Halve the size of array when queue is quarter-full
    	
    	return item;
    	
    	}
   /**
    * return (but do not delete) a random item
    * @return randomly select and return the item without deleting
    */
   public Item sample()  {                   
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	   	int randnbr = (first + StdRandom.uniform(N)) % q.length;
	   	Item item = q[randnbr]; 
	   	
	   	/**  old code with linked list implementation
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
	   	*/
	   	return item;	
   }
   public Iterator<Item> iterator()   {      // return an independent iterator over items in random order
	   return new ListIterator();
   }
   // an iterator, doesn't implement remove() since it's optional
   private class ListIterator implements Iterator<Item> {
	   private int[] order;
		private int index;

		public ListIterator() {
			order = new int[N]; //randomize the order of array Item array using a int array
			for (int i = 0; i < N; ++i) {
				order[i] = (first + i) % q.length;
			}
			StdRandom.shuffle(order);
			index = 0;
		}

		public boolean hasNext() {
			return index < order.length;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = q[order[index++]];
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
