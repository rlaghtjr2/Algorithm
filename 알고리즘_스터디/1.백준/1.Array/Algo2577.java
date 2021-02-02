package algo;

import java.util.Scanner;

public class Algo2577 {
	static int A,B,C,mult;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ans = new int[10];
		A=sc.nextInt();
		B=sc.nextInt();
		C=sc.nextInt();
		
		mult = A*B*C;
		String[] devide = String.valueOf(mult).split("");
		for(int i=0;i<devide.length;i++) {
			ans[Integer.parseInt(devide[i])]++;
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(ans[i]);
		}
	}

}
