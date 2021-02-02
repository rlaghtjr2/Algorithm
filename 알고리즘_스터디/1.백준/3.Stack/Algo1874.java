package acmpic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Algo1874 {
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		Stack<Integer> stk = new Stack<>();
		ArrayList<String> ans = new ArrayList<>();
		int num = 0;
		boolean isCheck = true;
		
		int cnt=1;
		int check =0;
		while(true) {
			if(num==0) {
				num = sc.nextInt();
			}
			
			if(stk.empty()) {
				stk.add(cnt);
				cnt++;
				ans.add("+");
			}
			
			if(num==stk.peek()) {
				stk.pop();
				ans.add("-");
				check++;
				if(check!=N) {
					num = sc.nextInt();
				}else {
					break;
				}
			}else if(num>stk.peek()) {
				stk.add(cnt);
				cnt++;
				ans.add("+");
			}else if(num<stk.peek()) {
				isCheck = false;
				break;
			}			
		}
		
		if(isCheck) {
			for(int i=0;i<ans.size();i++) {
				bw.write(ans.get(i)+"\n");
			}
		}else {
			bw.write("NO");
		}
		bw.flush();
		bw.close();
	}

}
