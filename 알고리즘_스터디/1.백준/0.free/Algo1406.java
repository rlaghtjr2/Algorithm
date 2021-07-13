import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Algo1406 {
	static String s,answer,answer2;
	static int M;
	static Stack<Character> stk,stk2;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		s = br.readLine();
		M = Integer.parseInt(br.readLine());
		stk = new Stack<>();
		stk2 = new Stack<>();
		answer="";
		answer2="";
		for(int i=0;i<s.length();i++) {
			stk.add(s.charAt(i));
		}
		
		for(int num = 0; num<M;num++) {
			String[] comm = br.readLine().split(" ");
			
			if(comm[0].equals("L")) {
				if(!stk.isEmpty())
					stk2.add(stk.pop());
			}else if(comm[0].equals("D")) {
				if(!stk2.isEmpty()) stk.add(stk2.pop());
			}else if(comm[0].equals("B")) {
				if(!stk.isEmpty()) stk.pop();
			}else if(comm[0].equals("P")) {
				stk.add(comm[1].charAt(0));
			}
		}
		while(!stk.isEmpty()) {
			stk2.add(stk.pop());
		}
		while(!stk2.isEmpty()) {
			bw.write(stk2.pop());
		}
		br.close();
        bw.flush();
        bw.close();
	}

}
