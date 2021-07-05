import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo1062 {
	static int max = Integer.MIN_VALUE;
	static int N,K;
	static boolean[] alphabet;
	static char[] v;
	static String[] words;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");;
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		alphabet = new boolean[26];
		alphabet['a'-97] = true;
		alphabet['n'-97] = true;
		alphabet['t'-97] = true;
		alphabet['i'-97] = true;
		alphabet['c'-97] = true;
		
		if(K<5) {
			for(int i=0;i<N;i++) {
				input = br.readLine().split(" ");
			}
			System.out.println(0);
			System.exit(0);
		}else if( K == 26) {
			System.out.println(N);
			System.exit(0);
		}
		
		v = new char[K-5];
		words = new String[N];
		
		for(int i=0;i<N;i++) {
			words[i] = br.readLine();
		}
		
		comb(0,0);
		System.out.println(max);
	}
	
	private static void comb(int cnt, int num) {
		if(num == K-5) {
			//System.out.println(Arrays.toString(v));
			check();
			return;
		}
		
		for(int i=cnt;i<26;i++) {
			if(alphabet[i]) continue;
			
			alphabet[i] = true;
			v[num] = (char)(i+97);
			comb(i+1,num+1);
			alphabet[i] = false;
		}
	}
	
	private static void check() {
		int num = 0;
		for(int i=0;i<N;i++) {
			boolean flag = true;
			for(int j=0;j<words[i].length();j++) {
				if(!alphabet[words[i].charAt(j) - 97]) {
					flag = false;
					break;
				}
			}
			if(flag) num++;
		}
		max = Math.max(max, num);
	}
}
