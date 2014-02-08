/**
 * Dependencies: StdIn.java StdOut.java
 * Percolation DataStructure
 */

/**Aim is to estimate the percolation threshold
 * Operations: Mean and Standard Deviation
 * Implements Percolation Datastructure
 * @author prakash
 *
 */
public class PercolationStats {

	private int totalT;
	private double[] perThreshold;
	private double mean;
	private double SD;
	/**
	 * @param args
	 */


	/**perform T independent computational experiments on an N-by-N grid
	 * @param N which determines the value of NxN matrix
	 * @param T : number of Independent COmputational Experiments
	 * 
	 */
	public PercolationStats(int N, int T)  {  

		totalT=T;
		perThreshold=new double[T];

		if (N<=0 || T<=0){
			throw new java.lang.IllegalArgumentException();
		}
		for(int i=0;i<totalT;++i){
			Percolation P= new Percolation(N);
			int openCount=0;
			Boolean isPercolated=false;
			while(!isPercolated){	//check until it gets percolated
				int row=StdRandom.uniform(N) + 1;	//selecting the random number
				int col=StdRandom.uniform(N) + 1;
				if(!P.isOpen(row, col)){
					P.open(row, col);
					++openCount;
					if(P.percolates()){		//if percolated then set it to true
						isPercolated=true;	
					}
				}
			}
			//The fraction of sites that are opened when the system percolates 
			//provides an estimate of the percolation threshold.
			perThreshold[i]= ((double)openCount/(double)(N*N)); 
		}
		mean=StdStats.mean(perThreshold);
		SD=StdStats.stddev(perThreshold);
	}
	/*
	 * sample mean of percolation threshold
	 */
	public double mean() {                     
		return mean;
	}
	/*
	 * sample standard deviation of percolation threshold
	 */
    public double stddev() {                   
    	return SD;
    }
    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {            
    	return ( mean - (1.96 * SD)/(Math.sqrt(totalT)));
    }
    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {            
    	return ( mean + (1.96 * SD)/(Math.sqrt(totalT)));
    }
    
    public static void main(String[] args) {
		// a main() method that takes two command-line arguments N and T
		int argsN= Integer.parseInt(args[0]);
		int argsT=Integer.parseInt(args[1]);
		PercolationStats PS= new PercolationStats(argsN,argsT);
		double mean= PS.mean();
		double SD=PS.stddev();
		System.out.println("mean						="+mean);
		System.out.println("stddev						="+SD);
		System.out.println("95% confidence interval   	= "+PS.confidenceLo()+", "+PS.confidenceHi());

	}
}