import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo1411 {
	static int N,ans;
	static String[] s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		s = new String[N];
		for(int i=0;i<N;i++) {
			s[i] = br.readLine();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				solve(i,j);
			}
		}
		System.out.println(ans);
	}

	public static void solve(int first, int second) {
		int v1[] = new int[26];
		int v2[] = new int[26];
		Arrays.fill(v1, -1);
		Arrays.fill(v2, -1);
		boolean c = true;
		if(s[first].length()!=s[second].length()) return;
		
		for(int i=0;i<s[first].length();i++) {
			int s1 = s[first].charAt(i);
			int s2 = s[second].charAt(i);
			
			if(v1[s1-'a']==-1 && v2[s2-'a']== -1) {
				v1[s1-'a'] = s2-'a';
				v2[s2-'a'] = s1-'a';
			}else if(v1[s1-'a']!=s2-'a' || 
					v2[s2-'a']== -s1-'a') {
				c = false;
				break;
			}
		}
		if(c) ans++;
	}
}
