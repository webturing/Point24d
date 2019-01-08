package demo;

public class ExceptionDemo {
public static void main(String[] args) {
	try {
		System.out.println(1/0);//ArithmeticException
	} catch (ArithmeticException e) {
		System.out.println("I catched it!");
	}
	System.out.println("hello");
	double c=Double.parseDouble("11asfasd23");//NumberFormatException
}
}
