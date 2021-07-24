import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//처음에 combination + set 사용 -> 메모리 초과
public class Algo6443 {
	static int N,result;
	static String s;
	static int[] alphabet;
	static char[] c;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<N ; tc++) {
			s = br.readLine();
			
			alphabet = new int[26];
			c = new char[s.length()];
			for(int i=0;i<s.length();i++) {
				alphabet[s.charAt(i)-'a']++;
			}
			
			setResult(0);
		}
		bw.close();
	}
	
	public static void setResult(int cnt) throws IOException {
		if(cnt == s.length()) {
			String ss = new String(c);
			bw.write(ss+"\n");
			bw.flush();
			return;
		}
		
		for(int i=0;i<26;i++) {
			if(alphabet[i]==0) continue;
			
			alphabet[i]--;
			c[cnt] = (char)(i+'a');
			
			setResult(cnt+1);
			
			alphabet[i]++;
		}
		
	}
	
}
