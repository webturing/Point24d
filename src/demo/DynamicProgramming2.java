package demo;

public class DynamicProgramming2 {
	static int fib(int n){
		if(n<=1)return n;
		return fib(n-1)+fib(n-2);
	}
	public static void main(String[] args) {	
		
		for(int i=1;i<=50;i++){
			long start=System.currentTimeMillis();
			System.out.print("T("+i+")=");
			fib(i);
			long end=System.currentTimeMillis();
			System.out.println(end-start);
		}
		
	}
}
