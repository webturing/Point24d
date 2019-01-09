package demo.ai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Evaluator {
	public static void main(String[] args) {
		String[] exp = " 1 2 + 3 4 * ".trim().split("\\s+");

		System.out.println(eval(exp));
		List<String> list=new ArrayList<String>();
		list.add("5");
		list.add("1");
		list.add("5");
		list.add("/");
		list.add("-");
		list.add("5");
		list.add("*");
		System.out.println(list);
		System.out.println(eval(list));
	}
	public static double eval(List<String>exp) {
		Stack<Double> stack = new Stack<Double>();
		for (String s : exp) {// neat and elegant
			if (isNumber(s)) {
				stack.push(Double.parseDouble(s));
			} else if (isOperator(s)) {
				if(stack.isEmpty())return -1;
				double b = stack.pop();
				if(stack.isEmpty())return -1;
				double a = stack.pop();
				double c = 0;
				switch (s.charAt(0)) {
				case '+':
					c = a + b;
					break;
				case '-':
					c = a - b;
					break;
				case '*':
					c = a * b;
					break;
				case '/':
					if (b != 0)
						c = a / b;
					else
						c = Double.MAX_VALUE;
					break;

				}
				stack.push(c);
			}
		}
		if(stack.size()!=1)return -1;
		return stack.peek();
	}
	public static double eval(String[] exp) {
		return eval(Arrays.asList(exp));//delegate
	}

	public static boolean isOperator(String s) {
		return  s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
	}

	public static boolean isNumber(String s) {		
		try{
			double x=Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

}
