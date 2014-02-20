
/**
 * Subset.java that takes a command-line integer k; reads in a sequence of N strings 
 * from standard input using StdIn.readString(); and prints out exactly k of them, 
 * uniformly at random.
 * @author Prakash
 * @mail prakash.natarajan@outlook.com
 */
public class Subset {
	private static int total(final String[] args) {
        try {
            return Integer.parseInt(args[0]);
        } catch (final NumberFormatException err) {
            throw new IllegalArgumentException(err);
        }
    }
	public static void main(String[] args) {
		int k = total(args);
		RandomizedQueue<String> a = new RandomizedQueue<String>();
		final String[] str = StdIn.readAllStrings();
		
		for (String s : str)
			a.enqueue(s);
		/* old format
		//number of sequence
		StdOut.println("Enter the Number of strings");
		int n = StdIn.readInt();
		StdOut.println("Enter the Elements for the queue");
		for ( int i =0; i < n; i++){
			String item = StdIn.readString();
			a.enqueue(item);
		}
		**/
		//print out k items randomly selected from N elements
		for (int j = 0; j < k ; j++){
			String item = a.dequeue();
			StdOut.println(item);
		}
		
	}

}
