package demo;

import java.util.Vector;

public class ExceptionDemo {
	public static void main(String[] args) {
		try {
			System.out.println(1 / 0);// ArithmeticException
		} catch (ArithmeticException e) {
			System.out.println("I catched it!");
		}
		System.out.println("hello");
		// double c=Double.parseDouble("11asfasd23");//NumberFormatException
		int[] a = new int[] { 1, 2, 3 };
		a[2] = 5;
		try {
			a[3] = 6;
		} catch (ArrayIndexOutOfBoundsException e) {
			int[] b = new int[a.length * 2];// ±¶Ôö
			// for(int i=0;i<a.length;i++)b[i]=a[i];//ugly but right
			System.arraycopy(a, 0, b, 0, a.length);// elegant and efficient

			a = b;
			a[3] = 6;
		}
		System.out.println(a[3]);
		Vector<Integer> v = new Vector<Integer>();
		v.add(1);
	}
}
