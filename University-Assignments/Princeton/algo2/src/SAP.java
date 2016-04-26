/**
 * 
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
	   Map<Integer, Integer> getAncestor(int v) {
		  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		  Queue<Integer> q = new LinkedList<Integer>();
		  q.add(v);
		  map.put(v, 0);
		  while(!q.isEmpty()) {
			Integer head = q.remove();
			Integer dist = map.get(head);
			for(Integer w: paths.adj(head)) {
				if(!map.containsKey(w) || (map.get(w) > dist + 1)) {
					map.put(w, dist + 1);
				} 
				q.add(w);
			}
		  }
		  return map;
		   
	   }
	   // length of shortest ancestral path between v and w; -1 if no such path
	   public int length(int v, int w) {
		   Map<Integer, Integer> v2dist = getAncestor(v);
		   Map<Integer, Integer> w2dist = getAncestor(w);
		   int dist = -1;
		   for(Integer vkey : v2dist.keySet()) {
			   if(w2dist.containsKey(vkey)) {
				   int currentDist = v2dist.get(vkey) + w2dist.get(vkey);
				   if(dist < 0 || currentDist < dist) {
					   dist = currentDist; 
				   }
			   }
		   }
		   return dist;
	   }

	   // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	   public int ancestor(int v, int w) {
		   Map<Integer, Integer> v2dist = getAncestor(v);
		   Map<Integer, Integer> w2dist = getAncestor(w);
		   int dist = -1;
		   int anc = -1;
		   for(Integer vkey : v2dist.keySet()) {
			   if(w2dist.containsKey(vkey)) {
				   int currentDist = v2dist.get(vkey) + w2dist.get(vkey);
				   if(dist < 0 || currentDist < dist) {
					   dist = currentDist; 
					   anc = vkey;
				   }
			   }
		   }
		   return anc;
	   }

	   // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
	   public int length(Iterable<Integer> v, Iterable<Integer> w) {
		   int dist = -1;
		   for(Integer vv : v) {
			   for(Integer ww: w) {
				   int currentDist = length(vv,ww);
				   if(dist < 0 || currentDist < dist) {
					   dist = currentDist;
				   }
			   }
		   }
		   
		   return dist;
	   }

	   // a common ancestor that participates in shortest ancestral path; -1 if no such path
	   public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		   int dist = -1;
		   int anc = -1;
		   for(Integer vv : v) {
			   for(Integer ww: w) {
				   int currentDist = length(vv,ww);
				   if(dist < 0 || currentDist < dist) {
					   dist = currentDist;
					   anc = ancestor(vv, ww);
				   }
			   }
		   }
		   
		   return anc;
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

