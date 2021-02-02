package acmpic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
class Pair{
	int x;
	int y;
	
	public Pair() {
	}
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int first() {
		return x;
	}
	
	public int second() {
		return y;
	}
	
	public void setFirst(int a) {
		x = a;
	}
	public void setSecond(int a) {
		y = a;
	}
	
}
public class Algo17298 {
	static int N;
	public static void main(String[] args) throws IOException {
		int cnt;
		int max;
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=sc.nextInt();
		Stack<Pair> stk = new Stack<>();
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			
			while(!stk.empty()) {
				if(num>stk.peek().first()) {
					ans[stk.peek().second()]=num;
					stk.pop();
				}else {
					break;
				}
			}
			
			stk.add(new Pair(num,i));
		}
		for(int i=0;i<ans.length;i++) {
			bw.write(ans[i]+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
