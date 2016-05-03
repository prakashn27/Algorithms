import java.awt.Color;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author prakashn
 *
 */
public class SeamCarver {
	private Picture pic;
	
	public SeamCarver(Picture picture) // create a seam carver object based on the given picture
	{
		pic = picture;
	}
	public Picture picture()  // current picture
	{
		return  pic;
	}
	public  int width() // width of current picture
	{
		return pic.width();
		
	}
	public  int height()// height of current picture
	{
		return pic.height();
		
	}
	private double sqrOfXGradient(int x, int y) {
		if(x == 0 || x == pic.width()) {
			return 1000;
		}
		Color x1 = pic.get(x - 1, y);
		Color x2 = pic.get(x + 1, y);
		double rx = x1.getRed() - x2.getRed();
		double bx = x1.getBlue() - x2.getBlue();
		double gx = x1.getGreen() - x2.getGreen();
		double result = rx*rx + bx*bx + gx*gx;
		return result;
	}
	private double sqrOfYGradient(int x, int y) {
		if(y == 0 || y == pic.height()) {
			return 1000;
		}
		Color y1 = pic.get(x, y - 1);
		Color y2 = pic.get(x, y + 1);
		double ry = y1.getRed() - y2.getRed();
		double by = y1.getBlue() - y2.getBlue();
		double gy = y1.getGreen() - y2.getGreen();
		double result = ry*ry + by*by + gy*gy; 
		return result;
	}
	public  double energy(int x, int y) throws IndexOutOfBoundsException
	{
		if(x < 0 || x >= pic.width() || y < 0 || y >= pic.height()) {
			throw new IndexOutOfBoundsException();
		}
		if(x == 0 || x == pic.width() - 1 || y == 0 || y == pic.height() - 1) {
			return 1000.0;
		}
		double result = Math.sqrt(sqrOfXGradient(x, y) + sqrOfYGradient(x, y)); 
		return result;
	}
	public int[] findHorizontalSeam()// sequence of indices for horizontal seam
	{
		return null;
		
	}
	public int[] findVerticalSeam()  // sequence of indices for vertical seam
	{
		return null;
		
	}
	public void removeHorizontalSeam(int[] seam)// remove horizontal seam from current picture
	{
		
	}
	public void removeVerticalSeam(int[] seam)  // remove vertical seam from current picture
	{
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Picture picture = new Picture("reference_files/seamCarving/12x10.png");
        StdOut.printf("image is %d pixels wide by %d pixels high.\n", picture.width(), picture.height());
        
        SeamCarver sc = new SeamCarver(picture);
        
        StdOut.printf("Printing energy calculated for each pixel.\n");        

        for (int row = 0; row < sc.height(); row++) {
            for (int col = 0; col < sc.width(); col++)
                StdOut.printf("%9.2f ", sc.energy(col, row));
            StdOut.println();
        }
	}

}
