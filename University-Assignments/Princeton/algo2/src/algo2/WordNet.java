package algo2;
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

   HashMap<Integer, Synset> id2synset;
   Digraph G;
   HashMap<String, Set<Integer>> noun2id;
   
   // constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms){
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
   }

   // returns all WordNet nouns
   public Iterable<String> nouns() {
	   return noun2id.keySet();
   }

   // is the word a WordNet noun?
   public boolean isNoun(String word) {
	   return noun2id.containsKey(word);
   }

   // distance between nounA and nounB (defined below)
   public int distance(String nounA, String nounB) {
	   if(!isNoun(nounA) || !isNoun(nounB)) {
		   throw new IllegalArgumentException("Distance function nounA or nounB is not valid");
	   }
	   // run BFS to the get the minimum distance between them
	   
	   Set<Integer> id1_list = noun2id.get(nounA);
	   Set<Integer> id2_list = noun2id.get(nounB);
	   int dist = -1;
	   for(Integer id : id1_list) {
		   if(id2_list.contains(id)) {
			   break;
		   }
		   dist++;
	   }
	   
	   
	   return 0;
   }

   // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
   // in a shortest ancestral path (defined below)
   public String sap(String nounA, String nounB) {
	   if(!isNoun(nounA) || !isNoun(nounB)) {
		   throw new IllegalArgumentException("Distance function nounA or nounB is not valid");
	   }
	   return new String();
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
