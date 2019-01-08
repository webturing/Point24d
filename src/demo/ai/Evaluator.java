package demo.ai;

import java.util.Arrays;
import java.util.Stack;

public class Evaluator {
	public static void main(String[] args) {
		String[] exp = "    5 1 5 / -    5    *        ".trim().split("\\s+");
		System.out.println(Arrays.toString(exp));
		System.out.println(Arrays.asList(exp));
		Stack<Double> stack = new Stack<Double>();
		for (String s : exp) {// neat and elegant
			if (isNumber(s)) {
				stack.push(Double.parseDouble(s));
			} else if (isOperator(s)) {
				double b = stack.pop();
				double a = stack.pop();
				double c = 0;
				switch (s) {
				case "+":
					c = a + b;
					break;
				case "-":
					c = a - b;
					break;
				case "*":
					c = a * b;
					break;
				case "/":
					if (b != 0)
						c = a / b;
					else
						c = Double.MAX_VALUE;
					break;

				}
				stack.push(c);
			}
		}
		System.out.println(stack.peek());

	}

	private static boolean isOperator(String s) {
		return  s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
	}

	private static boolean isNumber(String s) {		
		try{
			double x=Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

}
