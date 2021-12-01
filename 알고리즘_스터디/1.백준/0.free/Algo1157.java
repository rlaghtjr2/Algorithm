import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1157 {
	static String word,ans;
	static int[] array;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine();
		word = word.toLowerCase();
		array = new int[123];
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			array[(int)c]++;
		}
		
		int max = 0;
		for(int i=97;i<123;i++) {
			max = Math.max(max, array[i]);
		}
		ans = "NO";
		for(int i=97;i<123;i++) {
			if(ans.equals("NO") && array[i]==max) {
				ans = Character.toString((char)i);
			}else if(!ans.equals("NO") && array[i]==max) {
				ans = "?";
				break;
			}
		}
		
		if(!ans.equals("?")) ans=ans.toUpperCase();
		
		System.out.println(ans);
		
	}

}
