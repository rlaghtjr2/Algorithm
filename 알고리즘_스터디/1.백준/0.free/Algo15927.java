import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo15927 {
	static String s;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		//회문이면 (문자열 길이 -1)
		// 회문이 아니면 문자열 길이
		// 회문인데, 모든문자가 다같으면 -1
		if(checkPelin(s)) {
			if(checkCharacter(s)) System.out.println(-1);
			else System.out.println(s.length()-1);
			
		}else {
			System.out.println(s.length());
		}
	}
	
	
	public static boolean checkPelin(String s) {
		for(int i=0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	
	public static boolean checkCharacter(String s) {
		char c = s.charAt(0);
		for(int i=1;i<s.length();i++) {
			if(c != s.charAt(i)) return false; //다른경우
		}
		
		return true; // 다같은경우
	}
}
