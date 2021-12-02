import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo11720 {
	static int N,ans;
	static String[] s;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		s = br.readLine().split("");
		
		for(int i=0;i<s.length;i++) {
			ans+=Integer.parseInt(s[i]);
		}
		
		System.out.println(ans);
	}

}
