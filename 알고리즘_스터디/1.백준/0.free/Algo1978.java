import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo1978 {
	static int N,ans;
	static int[] num;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(num);
		v = new boolean[num[num.length-1]+1];
		v[0] = true;
		v[1] = true;
		//true = 소수가 아님
		//false = 소수
		
		for(int i=2;i<v.length;i++) {
			if(!v[i]) {
				for(int j=i+i;j<v.length;j=j+i) {
					v[j] = true;
				}
			}
		}
		for(int i=0;i<num.length;i++) {
			if(!v[num[i]]) ans++;
		}
		System.out.println(ans);
	}

}
