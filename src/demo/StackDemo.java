package demo;

import java.util.Stack;


public class StackDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Double> stack=new Stack<Double>();
		//use stack to calculate expression 1 5 /
		stack.push(1.0);//boxing  double->Double
		stack.push(5.0);
		double b=stack.pop();//unboxing Double->double
		double a=stack.pop();
		double c=a/b;
		stack.push(c);
		System.out.println(stack.peek());

	}

}
