package demo.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomSearcher {
	private static final int MAX_CNT = 1000;

	public static void main(String[] args) {
		int[] a=new int[]{1,5,5,5};
		System.out.println(search(a));
		
	}

	private static List<String> search(int[] a) {
		List<String> exp=new ArrayList<String>();
		for(int i:a)exp.add(Integer.toString(i));
		System.out.println(exp);
		exp.add("-");
		exp.add("*");
		exp.add("/");
		System.out.println(exp);
		System.out.println(Evaluator.eval(exp));
		int cnt=0;
		while(++cnt<MAX_CNT){
			Collections.shuffle(exp);
			if(Evaluator.eval(exp)==24.0){				
				return exp;
			}			
			
		}
		return exp;
	}
	
}
