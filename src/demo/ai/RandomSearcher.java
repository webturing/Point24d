package demo.ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSearcher {
	final static String[] OPS = "+ - * /".split("\\s+");
	private static final int MAX_CNT = 1000;
	private static Random random = new Random();

	public static void main(String[] args) {
		int[] a = new int[] { 1, 5, 5, 5 };
		System.out.println(search(a));
	}

	public static List<String> search(int[] a) {
		List<String> exp = new ArrayList<String>();
		int cnt = 0;
		for (int i = 0; i < 4; i++)
			exp.add(Integer.toString(a[i]));
		while (true) {
			List<String> ops = new ArrayList<String>();
			ops.add(OPS[random.nextInt(4)]);
			ops.add(OPS[random.nextInt(4)]);
			ops.add(OPS[random.nextInt(4)]);
			exp.addAll(ops);
			Collections.shuffle(exp);
			if (Evaluator.eval(exp) == 24.0) {
				return exp;
			}
			exp.removeAll(ops);// Ï¸½Ú
			++cnt;
			if (cnt > MAX_CNT) {
				return Arrays.asList("no solutions ?".split("\\s+"));
			}
		}
	}
}
