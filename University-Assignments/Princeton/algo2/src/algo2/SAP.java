/**
 * 
 */
package algo2;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author prakashn
 *
 */
public class SAP {
	  
	   Digraph paths;
	   // constructor takes a digraph (not necessarily a DAG)
	   public SAP(Digraph G) {
		   paths = G;
	   }

	   // length of shortest ancestral path between v and w; -1 if no such path
	   public int length(int v, int w) {
		   return 0;
	   }

	   // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	   public int ancestor(int v, int w) {
		   return 0;
	   }

	   // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
	   public int length(Iterable<Integer> v, Iterable<Integer> w) {
		   return 0;
	   }

	   // a common ancestor that participates in shortest ancestral path; -1 if no such path
	   public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		   return 0;
	   }

	   // do unit testing of this class
	   public static void main(String[] args) {
		    In in = new In("reference_files/wordnet/digraph1.txt");
		    Digraph G = new Digraph(in);
		    SAP sap = new SAP(G);
		    while (!StdIn.isEmpty()) {
		        int v = StdIn.readInt();
		        int w = StdIn.readInt();
		        int length   = sap.length(v, w);
		        int ancestor = sap.ancestor(v, w);
		        StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
		    }
	   }
	}

