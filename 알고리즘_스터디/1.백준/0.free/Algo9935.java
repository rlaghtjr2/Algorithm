import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algo9935 {
	static String s, bomb;
	static Stack<Character> stk;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		bomb = br.readLine();
		
		sb = new StringBuilder();
		stk = new Stack<>();
		
		for(int i=0;i<s.length();i++) {
			stk.add(s.charAt(i));
			if(stk.size()>=bomb.length()) {
				if(isCheck()) {
					for(int j=0;j<bomb.length();j++) {
						stk.pop();
					}
				}
			}
		}
		
		if(stk.isEmpty()) {
			System.out.println("FRULA");
		}else {
			for(char c : stk) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}
	private static boolean isCheck() {
		for(int i=stk.size()-bomb.length();i<stk.size();i++) {
			if(stk.get(i) != bomb.charAt(i-(stk.size()-bomb.length()))) return false;
		}
		return true;
	}

}
