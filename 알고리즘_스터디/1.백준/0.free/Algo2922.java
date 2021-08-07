import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo2922 {
	static String word;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine();
		
		System.out.println(makeWord(0, 0, false, 0));
	}
	
	
	
	public static long makeWord(int mnum, int jnum, boolean l, int index) {
		long ans = 0 ;
		if(mnum>=3 || jnum>=3) return 0;
	
		if(index == word.length()) {
			if(!l) return 0;
			else return 1;
		}
		if(word.charAt(index) != '_') {
			if(word.charAt(index)=='A' || word.charAt(index)=='E' || word.charAt(index)=='I' ||
					word.charAt(index)=='O' || word.charAt(index)=='U') {
				ans = makeWord(mnum+1,0,l,index+1);
			}else {
				if(word.charAt(index)=='L') ans = makeWord(0,jnum+1,true,index+1);
				else ans = makeWord(0,jnum+1,l,index+1);
			}
		}else {
			ans += (5*makeWord(mnum+1, 0, l, index+1));
			ans += (20*makeWord(0, jnum+1, l, index+1));
			ans += (1*makeWord(0, jnum+1, true, index+1));
			
		}
		//System.out.println(ans);
		return ans;
	}
}
