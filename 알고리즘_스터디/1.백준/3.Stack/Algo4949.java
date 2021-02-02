package acmpic;

import java.util.Scanner;
import java.util.Stack;

public class Algo4949 {
	
	static String s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String ans = "yes";
			s = sc.nextLine();
			if(s.length()==1)
				break;
			
			Stack<Character> stk = new Stack<>();
			
			for(int i=0;i<s.length()-1;i++) {
				if(s.charAt(i)== '(' || s.charAt(i) == '[') {
					stk.add(s.charAt(i));
				}else if(s.charAt(i)==')') {
					if(stk.empty() ||stk.pop() != '(') {
						ans = "no";
					}
				}else if(s.charAt(i) == ']') {
					if(stk.empty() || stk.pop() != '[') {
						ans = "no";
					}
				}
			}
			
			if(!stk.empty()) {
				ans = "no";
			}
			System.out.println(ans);
		}
	}

}
