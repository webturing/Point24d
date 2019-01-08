package demo;

import java.util.Arrays;

public class RegexDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] exp = " 5   1 5   / - 5 *  ".trim().split("\\s+");
		System.out.println(Arrays.toString(exp));
	}

}
