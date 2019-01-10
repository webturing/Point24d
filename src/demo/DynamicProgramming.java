package demo;

public class DynamicProgramming {
	static int[] F=new int[1000];
	static int fib(int n){
		if(F[n]!=0)
			 return F[n];
		if(n<=1)return F[n]=n;
		return F[n]=fib(n-1)+fib(n-2);
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
