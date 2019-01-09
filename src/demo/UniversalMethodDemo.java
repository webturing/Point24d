package demo;

public class UniversalMethodDemo {
	static int max2(int a, int b) {
		// TODO
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(max2(2, 3));
		System.out.println(max2(2.0, 3.5));
		System.out.println(max2("2", "3"));
		System.out.println(max2(2L, 3));

	}

	public static Comparable max2(Comparable ca, Comparable cb) {
		// TODO Auto-generated method stub
		return ca;
	}

	public static double max2(double d, double e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
