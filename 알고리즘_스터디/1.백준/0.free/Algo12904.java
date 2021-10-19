import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo12904 {
	static String S,T;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		while(S.length()<T.length()) {
			char c = T.charAt(T.length()-1);
			
			if(c=='A') {
				T = T.substring(0,T.length()-1);
			}else {
				T = new StringBuffer(T.substring(0,T.length()-1)).reverse().toString();
			}
//			System.out.println(S+" "+T);
		}
		if(S.equals(T)) System.out.println(1);
		else System.out.println(0);
	}

}
