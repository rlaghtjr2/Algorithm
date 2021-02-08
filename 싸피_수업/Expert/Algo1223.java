package expert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Algo1223 {
	static int T;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		for(int tc =1 ; tc<=10 ; tc++) {
			int sum = 0;
			T = Integer.parseInt(sc.nextLine());
			String[] cal = sc.nextLine().split("");
			
			for(int i=0;i<cal.length;i++) {
				if(cal[i].equals("*")) {
					int start = Integer.parseInt(cal[i-1]);
					cal[i-1] = "0";
					int cnt = i;
					while(true) {
						if(cal[cnt].equals("*")) {
							start *= Integer.parseInt(cal[cnt+1]);
							cal[cnt+1] = "0";
						}else if(cal[cnt].equals("+") || cnt == cal.length-1) {
							i = cnt;
							break;
						}
						cnt++;
					}
					sum += start;
				}
			}
			
			for(int i=0;i<cal.length;i++) {
				if((int)cal[i].charAt(0)>=48 && (int)cal[i].charAt(0)<=57 ) {
					sum+= Integer.parseInt(cal[i]);
				}
			}
			System.out.println("#"+tc + " "+ sum);
		}
	}

}
