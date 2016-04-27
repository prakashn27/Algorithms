import java.io.IOException;
import java.lang.Iterable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdIn;

public class WordNet {

   private HashMap<Integer, Synset> id2synset;
   private Digraph G;
   private SAP paths;
   private HashMap<String, Set<Integer>> noun2id;
   
   private boolean isDAG(Digraph G) {
	   
	   return true;
   }
   
   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms) 
		   throws IllegalArgumentException, IOException {
	   if(synsets == null || hypernyms == null) {
		   throw new NullPointerException("Error in WordNet Constructor");
	   }
	   noun2id = new HashMap<String, Set<Integer>>();
	   id2synset = new HashMap<Integer, Synset>();
		 //Read data from synsets input file 
		In in = new In(synsets);
		String[] line;
		String[] synonyms;
		Synset synset;
		int id;
		while(!in.isEmpty()) {
			synset = new Synset();
			line = in.readLine().split(",");
			synset.synonyms = line[1];
			synset.set_nouns = new HashSet<String>();
			id = Integer.parseInt(line[0]);
			synonyms = line[1].split(" ");
			for(String s : synonyms) {
				synset.set_nouns.add(s);
				if(!noun2id.containsKey(s)) {
					Set<Integer> bag = new HashSet<Integer>();
					bag.add(id);
					noun2id.put(s, bag);
				} else {
					noun2id.get(s).add(id);
				}
			}
			synset.definition = line[2];
			id2synset.put(id, synset);
		}
		
		G = new Digraph(id2synset.size());
		// Read data from hypernyms input file
		in = new In(hypernyms);
		int v, w;
		while(!in.isEmpty()) {
			line =  in.readLine().split(",");
			w = Integer.parseInt(line[0]);
			for(int i = 1; i < line.length; i++) {
				v = Integer.parseInt(line[i]);
				G.addEdge(v, w);
			}
		}
		if(!isDAG(G)) {
			throw new IllegalArgumentException("NOT a DAG");
		}
		paths = new SAP(G);
   }

   // returns all WordNet nouns
   public Iterable<String> nouns() {
	   return noun2id.keySet();
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word) {
	   if(word == null) throw new NullPointerException("Exception in isNound function");
	   return noun2id.containsKey(word);
   }

   // distance between nounA and nounB (defined below)
   public int distance(String nounA, String nounB) {
	   if(nounA == null || nounB == null) {
		   throw new NullPointerException("Error in Distance function");
	   }
	   if(!isNoun(nounA) || !isNoun(nounB)) {
		   throw new IllegalArgumentException("Distance function nounA or nounB is not valid");
	   }
	   return paths.length(noun2id.get(nounA), noun2id.get(nounB));
   }

   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
   // in a shortest ancestral path (defined below)
   public String sap(String nounA, String nounB) {
	   if(nounA == null || nounB == null) {
		   throw new NullPointerException("Error in Sap function");
	   }
	   if(!isNoun(nounA) || !isNoun(nounB)) {
		   throw new IllegalArgumentException("Distance function nounA or nounB is not valid");
	   }
	   int result_id = paths.ancestor(noun2id.get(nounA), noun2id.get(nounB));
	   return id2synset.get(result_id).synonyms;
   }

   // do unit testing of this class
   public static void main(String[] args) {
	   WordNet wn = new WordNet("reference_files/wordnet/synsets.txt", "reference_files/wordnet/hypernyms.txt");
	   System.out.println("Hello World!");
   }

}

class Synset {
	public String synonyms;
	public Set<String> set_nouns;
	public String definition;
}
