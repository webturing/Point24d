package demo;
public class Permutation {
	public static void main(String[] args) {
		for (int a = 0; a < 4; a++)
			for (int b = 0; b < 4; b++)
				for (int c = 0; c < 4; c++)
					for (int d = 0; d < 4; d++) {
						if(a!=b&&a!=c&&a!=d&&b!=c&&b!=d&&c!=d)
						System.out.println(""+a+b+c+d);
					}
	}
}
