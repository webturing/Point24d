package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandDemo {
	/**
	 * javaËæ»úÊý
	 */
	static Random rand = new Random();

	public static void main(String[] args) {
		System.out.println(Math.random());
		System.out.println(rand.nextInt(10));
		List<Integer> balls = new ArrayList<Integer>();
		for (int i = 1; i <= 15; i++)
			balls.add(i);
		System.out.println(balls);
		Collections.shuffle(balls);
		System.out.println(balls);
		List<Integer> firstPrize = balls.subList(0, 6);
		System.out.println("First Prize:" + firstPrize);

	}

}
