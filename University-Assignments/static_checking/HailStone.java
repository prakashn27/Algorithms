package static_checking;

public class HailStone {
	public static void hailSeq(int n) {
		while(n != 1) {
			System.out.print(n+ " ");
			if(n % 2 == 0) n /= 2;
			else n = 3n + 1;
		}
		System.out.print(n);
	}
	public static void main(String[] args) {
		hailSeq(3);
	}
}
