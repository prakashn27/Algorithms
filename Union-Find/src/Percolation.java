/**
 * Dependencies: StdIn.java StdOut.java
 */

/**Percolation class represents a Percolation data structure
 * Operations supported: open
 * Functions : isOpen , isFull , whether it percolates
 * @author prakash
 *
 */
public class Percolation {

	/**
	 * Declare the datatypes needed for the class
	 */
	private WeightedQuickUnionUF grid;  //array initialization for storing the elements of grid
	private int totalN; 				//PlaceHolder of total array length
	private boolean[] state;			//true = open ; false-closed ; 
	/**create N-by-N grid, with all sites blocked
	 * @param Matrix value
	 * Dependencies: StdIn.java StdOut.java
	 */
	public Percolation(int N){      
		this.totalN=N;
		this.grid= new WeightedQuickUnionUF(N*N+2); //Two dimensional array length + 
																	//2(1 upper,Lower element)
		this.state= new boolean[N*N];
		for(int i=0;i<=(N*N);i++)
			this.state[i]=false;
	}
	/**open site (row i, column j) if it is not already
	 * @param row number
	 * @param column number
	 * @return NULL
	 * 
	 */
	 public void open(int row, int col)    {
		   // open site (row i, column j) if it is not already
		   checkIndex(row,col);	//checks for IndexOutOfBoundsException exception
		   if(isOpen(row,col))return;
		   int i=row-1;
		   int j=col-1;
		   int offset= 1*totalN +j;
		   this.state[offset]=true;		//opening the grid
		   
	   }
	   /**is site (row i, column j) open?
	    * @param row number
	    * @param column number
	    * @return  true  if the cell is open
	    * and  false  otherwise
	    * @throws java.lang.IndexOutOfBoundsException 
	    * if the specified index is out of bound 
	    */
	 public boolean isOpen(int row, int col)  {
		   checkIndex(row,col); 	//checks for IndexOutOfBoundsException exception
		   int i=row -1 ;
		   int j=col -1;
		   int offset= i*totalN+j;
		   return(state[offset]);
	   }   
	   // is site (row i, column j) full?
	   /**
	     * Is the sites  (row i, column j)  full??
	     * @param row number
	     * @param column number
	     * @return true if the site  (row i, column j) 
	     *   is full, and false  otherwise
	     * @throws java.lang.IndexOutOfBoundsException 
	     * if the specified row and column number is out of bounds
	     */
	 public boolean isFull(int row, int col) {
		   checkIndex(row,col);		//checks for IndexOutOfBoundsException exception
		   int i=row-1;
		   int j=col-1;
		   int offset=i*totalN+j;
		   int gridPos=offset+1;	//grid position is +1 to offset because of the upper point in top
		   
		   return( isOpen(row,col) && grid.connected(0, gridPos));
	   }
	   /**does the system percolate?
	    * @return true if the system percolate
	    * otherwise false
	    */
	 public boolean percolates()	{
		   // does the system percolate?
		   if(this.totalN==1){return(state[0]);}
		   return grid.connected(0, totalN*totalN+1);
		      
	   }
	   
	   /**
	    * Check whether the given elements are within the index
	     * @param row index i
	     * @param column index j
	     * @throws java.lang.IndexOutOfBoundsException
	     *  
	     */
	 public void checkIndex(int i, int j){
	 if(i> totalN || j>totalN || i< 1 || j<1) 
		throw new java.lang.IndexOutOfBoundsException();
	}
	}

}
