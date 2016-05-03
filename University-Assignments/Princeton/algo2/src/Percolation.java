import edu.princeton.cs.algs4.WeightedQuickUnionUF;

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
	 * Declare the data types needed for the class
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
		for(int i=0;i<(N*N);i++)
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
		   int mainRow= row-1;
		   int mainCol= col-1;
		   int offset= mainRow*totalN +mainCol;
		   int gridOffset = offset+1;
		   this.state[offset]=true;		//opening the grid
		   
		   //check for top row
		   if(mainRow == 0){
			   grid.union(0, gridOffset);
		   }
		   //check for bottomRow
		   if(mainRow == totalN-1 ){
			   grid.union(gridOffset, totalN*totalN+1);
		   }
		   //Check the top , bottom, left , right check for 
		   // Check Left
		   int leftRow= mainRow;
		   int leftCol= mainCol-1;
		   int leftGridOffset= leftRow*totalN+leftCol + 1;
		   if (leftCol>=0){
			   if(isOpen(leftRow + 1,leftCol +1)){
				  grid.union(leftGridOffset, gridOffset);
			   }
		   }	
		   //check right
		   int rightRow= mainRow;
		   int rightCol= mainCol+1;
		   int rigthGridOffset= rightRow*totalN+rightCol + 1;
		   if ( rightCol < totalN){
			   if(isOpen(rightRow + 1 ,rightCol + 1 )){
			   grid.union(rigthGridOffset, gridOffset);
			   }
		   }
		   //check up
		   int upRow= mainRow - 1;
		   int upCol= mainCol;
		   int upGridOffset= upRow*totalN+upCol + 1;
		   if ( upRow >= 0){
			   if(isOpen(upRow +1 , upCol + 1)){
			   grid.union(upGridOffset, gridOffset);
			   }
		   }
		   //Check down
		   int downRow= mainRow + 1;
		   int downCol= mainCol;
		   int downGridOffset= downRow*totalN+downCol + 1;
		   if ( downRow < totalN){
			   if(isOpen(downRow + 1,downCol + 1)){
			   grid.union(downGridOffset, gridOffset);
			   }
		   }
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
	 private void checkIndex(int i, int j){
	 if(i > totalN || j > totalN || i < 1 || j < 1) 
		 throw new java.lang.IndexOutOfBoundsException();
	}
	

}
