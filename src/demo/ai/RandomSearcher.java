package demo.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSearcher {
	final static String[] OPERATORS = "+ - * /".split("\\s+");
	private static final int MAX_CNT = 10000;
	private static Random random = new Random();

	public static void main(String[] args) {
		int[] a = new int[] { 1, 5, 5, 5 };
		System.out.println(search(a));
	}

	public static List<String> search(int[] a) {
		List<String> exp = new ArrayList<String>();
		for (int e : a)
			exp.add(Integer.toString(e));
		int cnt = 0;
		
		while (++cnt < MAX_CNT) {
			List<String> ops=new ArrayList<String>();
			ops.add(OPERATORS[random.nextInt(4)]);
			ops.add(OPERATORS[random.nextInt(4)]);
			ops.add(OPERATORS[random.nextInt(4)]);
			exp.addAll(ops);
			System.err.println(exp);
			Collections.shuffle(exp);
			if (Evaluator.eval(exp) == 24.0) {
				return exp;
			}
			exp.removeAll(ops);
			System.err.println(exp);
		}

		return new ArrayList<String>();
	}

}
