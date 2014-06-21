class bitSet {
	public static void main(String[] args) {
	 int a = 60;	/* 60 = 0011 1100 */  
   int b = 13;	/* 13 = 0000 1101 */
   int c = 0;
   c = a >> 2;     /* 215 = 1111 */
   int v = 13;
   int num_zeroes = 0;
  // count the number of one bits 
  	for (c = 0; v != 0; v >>= 1)
  	{
  	  c += v & 1;
  	  System.out.println(v);
  	}
       System.out.println("num ones =" + c);	
  	}
}
