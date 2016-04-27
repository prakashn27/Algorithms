
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
	
	private WordNet wn;
	
   public Outcast(WordNet wordnet)         // constructor takes a WordNet object
   {
	   wn = wordnet;
   }
   public String outcast(String[] nouns)   // given an array of WordNet nouns, return an outcast
   {
	   String result_key = "";
	   int maxDist = -1;
	   for(int i = 0; i < nouns.length; i++) {
		   int dist = 0;
		   for(int j = 0; j < nouns.length; j++) {
			   if(i == j) continue;
			   dist += wn.distance(nouns[i], nouns[j]);
			   if(maxDist < 0 || maxDist < dist) {
				   maxDist = dist;
				   result_key = nouns[i];
			   }
		   }
	   }
	   
	   /*
	   for(int k = 0; k < dist_of_nouns.size(); k++) {
		   if(maxDist < 0 || maxDist < dist_of_nouns.get(k)) {
			   maxDist = dist_of_nouns.get(k);
			   result_key = nouns[k];
		   }
	   }
	   */
	   return result_key;
   }
   public static void main(String[] args)  // see test client below
   {
	    WordNet wordnet = new WordNet("reference_files/wordnet/synsets.txt", "reference_files/wordnet/hypernyms.txt");
		Outcast outcast = new Outcast(wordnet);
		//for (int t = 2; t < args.length; t++) {
		    In in = new In("reference_files/wordnet/outcast5.txt");
		    String[] nouns = in.readAllStrings();
		    StdOut.println("outcast5" + ": " + outcast.outcast(nouns));
		//}
   }
}
