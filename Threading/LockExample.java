/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	ReentrantLock l1;
	public Ideone() {
		l1 = new ReentrantLock();
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Ideone pgm = new Ideone();
		Thread t1 = pgm.new T1();
		Thread t2 = pgm.new T2();
		t1.start();
		t2.start();
	}
	class T1 extends Thread {
		public void run() {
			System.out.println("t1 is runnng");
			try {
				l1.lock();
				this.sleep(1000);
				l1.unlock();
			} catch(Exception e) {
				
			}
		}
	}
	class T2 extends Thread {
		public void run() {
			System.out.println("t2 is runnng");
			l1.lock();
			l1.unlock();
		}
	}
}

