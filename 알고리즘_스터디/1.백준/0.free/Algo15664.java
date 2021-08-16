import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Algo15664 {

	static int N,M;
	static int[] nums,ans;
	static boolean[] v;
	static BufferedWriter bw;
	static LinkedHashSet<String> hashSet;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		nums = new int[N];
		ans = new int[M];
		v = new boolean[N];
		hashSet = new LinkedHashSet<>();

		input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(nums);
		comb(0,0);
		hashSet.forEach(System.out::println);
		bw.flush();
		bw.close();
	}
	
	public static void comb(int cnt,int num) throws IOException {
		if(cnt == M) {
			String s="";
			for(int i=0;i<M;i++) {
				s+=(ans[i]+" ");
			}
			hashSet.add(s);
			return;
		}
		
		for(int i=num;i<N;i++) {
			if(v[i]) continue;
			
			v[i] = true;
			ans[cnt] = nums[i];
			comb(cnt+1,i+1);
			v[i] = false;
		}
	}

}
