package expert;

import java.util.Scanner;
import java.util.Stack;

public class Algo1218 {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int ans = 1;
			N = Integer.parseInt(sc.nextLine());
			String[] s = sc.nextLine().split("");
			Stack<String> stk = new Stack<>();
			for(int i=0;i<N;i++) {
				if(s[i].equals("(") || s[i].equals("[")
						||s[i].equals("{") || s[i].equals("<")) {
					stk.push(s[i]);
				}else if(stk.empty()){
					ans = 0;
					break;
				}else if((stk.peek().equals("(") && s[i].equals(")")) ||
						(stk.peek().equals("[") && s[i].equals("]")) ||
						(stk.peek().equals("{") && s[i].equals("}")) ||
						(stk.peek().equals("<") && s[i].equals(">"))) {
					stk.pop();
				}else {
					ans = 0;
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
